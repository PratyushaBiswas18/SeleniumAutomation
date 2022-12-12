package nopComm;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
	
	
	
	
	@Test
	public void verifyLogin() throws Exception {
		
		System.out.println("login test case");
		
		driver.findElement(By.xpath("//input[contains(@id,'Email')]")).clear();
		driver.findElement(By.xpath("//input[contains(@id,'Email')]")).sendKeys(conf.get_adminuser());
		
		driver.findElement(By.xpath("//input[contains(@type,'pass')]")).clear();
		driver.findElement(By.xpath("//input[contains(@type,'pass')]")).sendKeys(conf.get_adminPass());
		
		
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
