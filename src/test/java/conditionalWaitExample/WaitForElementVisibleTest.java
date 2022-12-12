package conditionalWaitExample;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForElementVisibleTest {
	
	public WebDriver driver;
	Actions act;
	@BeforeTest
	public void launchApp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		
//		WebDriverManager.edgedriver().setup();
//		driver = new EdgeDriver();
		
		driver.get("http://only-testing-blog.blogspot.com/2014/01/textbox.html");
		driver.manage().window().maximize();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));			//wait applicable to all element
		
		//Create an Object
		act = new Actions(driver);
		
		
	}
	
	
	@AfterTest
	public void closeApp() throws Exception {
		Thread.sleep(5000);
		driver.close();
		System.out.println("closing application....");
	}
	

	@Test
	public void enterValueTest() {
		
		//conditionalwait
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));								//max time before exception
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#text3")));
		
		driver.findElement(By.cssSelector("#text3")).sendKeys("enter value test 3");;
		
	}
	
}
