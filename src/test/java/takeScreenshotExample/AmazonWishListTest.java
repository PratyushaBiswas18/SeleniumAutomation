package takeScreenshotExample;



import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonWishListTest {
	WebDriver driver;
	
	@BeforeTest
	public void loadPage() throws Exception {
		 String url = "https://www.amazon.in/";
		 driver = WebDriverManager.chromedriver().create();
		 driver.get(url);
		 driver.manage().window().maximize();
		 Thread.sleep(1000);
		 
	}
	
	@AfterTest
	public void closePage() throws Exception {
		Thread.sleep(5000);
		driver.close();
	}

	@Test
	public void alertHandle() throws Exception {
		
		
		WebElement SignIn = driver.findElement(By.xpath("//span[text()='Hello, sign in']"));
		
		WebElement WishList = driver.findElement(By.xpath("//span[text()='Create a Wish List']"));
		
		
		//Create an Object of Actions class
		
		Actions act = new Actions(driver);
		
//		//app1
//		act.moveToElement(SignIn).perform();
//		act.moveToElement(WishList).perform();
//		act.click().perform();
//		
//		//app2
//		act.moveToElement(SignIn).moveToElement(WishList).click().perform();
		
		//app3
		act.moveToElement(SignIn).click(WishList).perform();

		
		//validation step
		Assert.assertTrue(driver.getTitle().contains("Wish"));
		
		
		
		Thread.sleep(5000);
		//take a screenshot
		
//		JavascriptExecutor JS = (JavascriptExecutor) driver;
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		
//		File source = ts.getScreenshotAs(OutputType.FILE);
//		
		
		 
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		File target = new File(".\\screenshot\\AmazonWishList.png");
		
		FileUtils.copyFile(screenshotFile, target);
		
		Thread.sleep(2000);
	}
	
	
	
}
