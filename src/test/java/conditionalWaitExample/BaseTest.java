package conditionalWaitExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	Actions act;
	@BeforeTest
	public void launchApp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		
//		WebDriverManager.edgedriver().setup();
//		driver = new EdgeDriver();
		
		driver.get("http://only-testing-blog.blogspot.com/2014/01/new-testing.html?");
		driver.manage().window().maximize();
		
		
		//Create an Object
		act = new Actions(driver);
		
		
	}
	
	
	@AfterTest
	public void closeApp() throws Exception {
		Thread.sleep(5000);
		driver.close();
		System.out.println("closing application....");
	}
	
	
	

}
