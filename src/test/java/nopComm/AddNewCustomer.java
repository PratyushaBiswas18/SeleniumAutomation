package nopComm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddNewCustomer {
	
	WebDriver driver;
	//ctrl+Shoift+O ----- autoimport
	//pre-condition    ----- @BeforeSuite-----
	//Test
	//post-condition   ----- @AfterSuite
	
	
	@BeforeTest
	public void launchApp() {
		
		System.out.println("launching application");
		
		driver = WebDriverManager.chromedriver().create();
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		driver.manage().window().maximize();
		
	}
	
	@AfterTest
	public void closeApp() throws Exception {
		
		Thread.sleep(5000);
		driver.close();
		System.out.println("closing application");
	}
	
	
	@Test
	public void verifyLogin() throws Exception {
		
		System.out.println("login test case");
		
		driver.findElement(By.xpath("//input[contains(@id,'Email')]")).clear();
		driver.findElement(By.xpath("//input[contains(@id,'Email')]")).sendKeys("admin@yourstore.com");
		
		driver.findElement(By.xpath("//input[contains(@type,'pass')]")).clear();
		driver.findElement(By.xpath("//input[contains(@type,'pass')]")).sendKeys("admin");
		
		
		driver.findElement(By.xpath("//button[contains(text(),'Log')]")).click();
		
		Thread.sleep(4000);
		//validation step
		System.out.println("after sucessful login, application title: " + driver.getTitle());
		
		
		
		//click on Customer menu/item
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@href=\"#\"]//child::p[contains(text(),'Customers')]")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@href='/Admin/Customer/List']//child::p[contains(text(),'Customers')]")).click();
		////a[contains(@href,'Admin/Customer/List')]//child::p[contains(text(),'Customers')]
		
		Thread.sleep(4000);
		//validation step
		System.out.println("after click on Customer menu item, application title: " + driver.getTitle());
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[contains(text(),'Log')]")).click();
		Thread.sleep(4000);
	}
	
	

}
