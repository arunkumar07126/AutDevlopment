package seleniumFirstProgram;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Seleniumlogintest {

	static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Automation Starts");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Galaxy\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		Thread.sleep(1000);
		
		//Test 1 login
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		System.out.println("Page Tite Value is "+driver.getTitle());
		
		driver.findElement(By.xpath("//*[@id=\'txtUsername\']")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("admin123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='btnLogin']")).click();
		//Test 2 checking home page

		boolean orangeimagedisplayed = driver.findElement(By.xpath("//img[@src='/webres_6051af48107ce6.31500353/themes/default/images/logo.png']")).isDisplayed();

		if (orangeimagedisplayed)
	
		{
		System.out.println("Orange Image is displayed, we are in home page");
		}else {
			System.out.println("Orange Image not displayed, we are not in home page");
		}
		
		Thread.sleep(1000);
		
		//Test 3 Mouse Hover to admin and mouse hover to user mang and mouse hover to users
		driver.findElement(By.xpath("//*[@id='menu_admin_viewAdminModule']")).click();
				
		System.out.println("Admin Tab clicked");
		
		WebElement E1 = driver.findElement(By.xpath("//*[@id='menu_admin_viewAdminModule']"));
		
		System.out.println("mousehouseover function");
		
		WebElement E2 = driver.findElement(By.xpath("//*[@id='menu_admin_viewAdminModule']"));
		
		Actions A1 = new Actions(driver);
		A1.moveToElement(E2);
		A1.click(E2);
		A1.build().perform();
		
		driver.findElement(By.xpath("//*[@id='menu_admin_viewAdminModule']")).click();
		
		//WebElement adminusers = driver.findElement(By.xpath("//*[@id='menu_admin_UserManagement']"));
		
	    //driver.findElement(By.xpath("//*[@id='menu_admin_viewAdminModule']//following::li//a[@id='menu_admin_viewSystemUsers']")).click();
		
		System.out.println("admin user managment clicked");
		
	/*	//WebElement users = driver.findElement(By.xpath("//*[@id='mainMenuFirstLevelUnorderedList']/li[1]/ul/li[1]/ul/li[1]"));
		
		//users.click();
		
		WebElement E3 = driver.findElement(By.xpath("//a[@href='/index.php/admin/viewSystemUsers']"));
		
		Select s1 = new Select(E3);
		s1.selectByIndex(0);
		s1.selectByVisibleText("Users");
		
		
		//driver.findElement(By.xpath("//a[@href='/index.php/admin/viewSystemUsers']")).click();
		
		System.out.println("users page clicked");
		
		Thread.sleep(1000); */

		//Test 4 finding a value in the user table and finding the index position
		
/*		List<WebElement> resulttable =	driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr/td"));
		
		System.out.println("resulttable size is "+resulttable.size());
		
		for (int i = 0; i<=resulttable.size()-1; i++) {
			
			if (resulttable.get(i).getText().equals("Aaliyah Haq")) {
				
				System.out.println("Addeduser searched existing in result table");
				System.out.println("index position of the user serached is "+i);
				
		}
		} 
		
		//Test 5 Printing all values of result table using for each loop
		  for (WebElement webElement : resulttable) {
			System.out.println("Result table values "+webElement.getText());
		} */
		
		// Test 6 for enabling the checkbox next to serached user
		
		List<WebElement> resulttablerowvalue =	driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr"));
		List<WebElement> resulttabletdvalue =	driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr/td"));
		List<WebElement> resulttablecolumnvalue =	driver.findElements(By.xpath("//*[@id='resultTable']/thead/tr/th"));
		
		System.out.println("resulttablerow size is "+resulttablerowvalue.size());
		System.out.println("resulttabletdvalue size is "+resulttabletdvalue.size());
		
		String Xpath1;
		String Xpath2;
		
		for (int i = 1; i<=resulttablerowvalue.size()-1; i++) {
			
			for (int j = 1; j<=resulttablecolumnvalue.size()-1; j++) {
				
				Xpath1="//*[@id='resultTable']/tbody/"+"tr["+i+""+"]/"+"td["+j+""+"]";
				By Searchuser = By.xpath(Xpath1);
				
		if (driver.findElement(Searchuser).getText().equals("Fiona Grace")) {
				
			System.out.println("Addeduser searched existing in result table");
				System.out.println("tr value is "+i);
				System.out.println("td value is "+j);
				Xpath2 =Xpath1+"//preceding::td[3]";
				System.out.println("CheckBox Xpath is "+Xpath2);
				By checkbox = By.xpath(Xpath2);
				driver.findElement(checkbox).click();
				Thread.sleep(1000);
				boolean checkboxvalue= driver.findElement(checkbox).isSelected();
				System.out.println("CheckBox Selected is "+checkboxvalue);
					try {
					driver.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					Thread.sleep(1000);
				System.out.println("Automation ends");
				break;		
		}
			
		}
		}
		
		//driver.close();
		//driver.quit();

	}
	
}
