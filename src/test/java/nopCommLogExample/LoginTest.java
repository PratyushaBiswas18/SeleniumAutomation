package nopCommLogExample;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
	
	
	
	
	@Test
	public void verifyLogin() throws Exception {
		
		//System.out.println("login test case");
		
		log.info("clear the username field");
		log.warn("clear the username field");
		log.error("clear the username field");
		
		driver.findElement(By.xpath("//input[contains(@id,'Email')]")).clear();
		log.info("enter email id: " + conf.get_adminuser());
		driver.findElement(By.xpath("//input[contains(@id,'Email')]")).sendKeys(conf.get_adminuser());
		
		log.info("clear the password field");
		driver.findElement(By.xpath("//input[contains(@type,'pass')]")).clear();
		log.info("enter password id: " + conf.get_adminPass());
		driver.findElement(By.xpath("//input[contains(@type,'pass')]")).sendKeys(conf.get_adminPass());
		
		log.info("Click on Login button");
		driver.findElement(By.xpath("//button[contains(text(),'Log')]")).click();
		
		Thread.sleep(4000);
		//validation step
		log.info("after sucessful login, application title: " + driver.getTitle());
		//log.info("Click on Login button");
		
		
		//click on Customer menu/item
		
		Thread.sleep(4000);
		log.info("Click on Customer Menu");
		driver.findElement(By.xpath("//a[@href=\"#\"]//child::p[contains(text(),'Customers')]")).click();
		
		log.info("Click on Customer Menu items");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@href='/Admin/Customer/List']//child::p[contains(text(),'Customers')]")).click();
		////a[contains(@href,'Admin/Customer/List')]//child::p[contains(text(),'Customers')]
		
		Thread.sleep(4000);
		//validation step
		log.info("after click on Customer menu item, application title: " + driver.getTitle());
		
		Thread.sleep(4000);
		log.info("Click on Logout");
		driver.findElement(By.xpath("//a[contains(text(),'Log')]")).click();
		Thread.sleep(4000);
	}
	
	

}
