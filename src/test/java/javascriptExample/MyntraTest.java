package javascriptExample;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyntraTest {
	WebDriver driver;
	
	@BeforeTest
	public void loadPage() throws Exception {
		 String url = "https://www.myntra.com/";
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
		
		
		WebElement returnPolicy30Days = driver.findElement(By.xpath("//strong[contains(text(),'Return within 30days')]"));
		
		
		
		JavascriptExecutor  JS  = (JavascriptExecutor) driver;
		
		JS.executeScript("arguments[0].scrollIntoView()", returnPolicy30Days);
		
		
		
		
		

		
	}
	
	
	
}
