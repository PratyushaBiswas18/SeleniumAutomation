package frameExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ReadConfig;

public class IFrame_SeleniumAction {

	
	public WebDriver driver;
	public ReadConfig conf;
	//ctrl+Shoift+O ----- autoimport
	//pre-condition    ----- @BeforeSuite-----
	//Test
	//post-condition   ----- @AfterSuite
	
	
	@BeforeTest
	public void launchApp() throws Exception {
		
		System.out.println("launching application");
		
		
		//create an Object on ReadConfig file
		conf = new ReadConfig();
		
		driver = WebDriverManager.chromedriver().create();
		//driver.get(conf.get_NOP_URL());
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?org/openqa/selenium/support/ui/Select.html");
		driver.manage().window().maximize();
		
	}
	
	@AfterTest
	public void closeApp() throws Exception {
		
		Thread.sleep(5000);
		driver.close();
		System.out.println("closing application");
	}

	@Test
	public void verifypayTMAccount() throws Exception {
		
		//SwitchToFrame2
		WebElement myFrame = driver.findElement(By.cssSelector("iframe[title*='All classes and interfaces']"));
		driver.switchTo().frame(myFrame);
		
		
		Thread.sleep(3000);
		WebElement ActionEle = driver.findElement(By.xpath("//a[text()='Actions']"));
		ActionEle.click();
		Thread.sleep(3000);
		
			
		//
		driver.switchTo().defaultContent();
		
		
		Thread.sleep(3000);
		//SwitchToFrame3
		WebElement myFrame3 = driver.findElement(By.cssSelector("iframe[title*='Package, class']"));
		driver.switchTo().frame(myFrame3);
		
		driver.findElement(By.xpath("//code[text()='perform()']")).click();
		
		Thread.sleep(5000);
	}
	
}
