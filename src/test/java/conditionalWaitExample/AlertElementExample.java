package conditionalWaitExample;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertElementExample {

	public WebDriver driver;
	Actions act;
	@BeforeTest
	public void launchApp() {
		
		
		driver = new ChromeDriver();
		driver.get("http://only-testing-blog.blogspot.com/2014/01/new-testing.html?");
		driver.manage().window().maximize();
		
		
		
	}
	
	
	@AfterTest
	public void closeApp() throws Exception {
		Thread.sleep(5000);
		driver.close();
		
	}
	
	
	@Test
	public void verifyTextBox() {
		
		//element
		//handle sync issue
		//conditional wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.alertIsPresent());
		
		
		String alertText = driver.switchTo().alert().getText();
		
		System.out.println("alert text: " + alertText);
		
		driver.switchTo().alert().accept();
		
	}
}
