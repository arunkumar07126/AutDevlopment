package seleniumFirstProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google {

	static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Automation Starts");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Galaxy\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Test 1 login
		driver.get("https://www.google.com/");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		System.out.println("Page Tite Value is "+driver.getTitle());
		
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Hello");
		//driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("admin123");
		Thread.sleep(1000);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='gNO89b']//following::input[@value='Google Search']")).click();
		driver.close();
		driver.quit();
	}

}
