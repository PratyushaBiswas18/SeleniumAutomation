package javascriptExample;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ModelExample {
	WebDriver driver;
	
	@BeforeTest
	public void loadPage() throws Exception {
		 String url = "http://www.uitestpractice.com/Students/Switchto";
		 driver = WebDriverManager.chromedriver().create();
		 driver.get(url);
		 driver.manage().window().maximize();
		 Thread.sleep(1000);
		 
	}
	
	@AfterTest
	public void closePage() throws Exception {
		Thread.sleep(1000);
		driver.close();
	}

	@Test
	public void alertHandle() throws Exception {
		
		System.out.println("executing test in progress...");
		Thread.sleep(7000);
		WebElement launchModel = driver.findElement(By.xpath("//button[contains(text(), 'Launch modal')]"));
		
		
		
		JavascriptExecutor  JS  = (JavascriptExecutor) driver;
		
		JS.executeScript("arguments[0].click()", launchModel);
		
		
		
		
		Thread.sleep(500);
		String title=driver.findElement(By.xpath("//h4[@class = 'modal-title']")).getText();
		System.out.println("Title: "+title);
		
		String body=driver.findElement(By.xpath("//div[@class = 'modal-body']")).getText();
		System.out.println("Body: \n"+body);
		
		driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();

		
	}
	
	
	
}
