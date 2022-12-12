package controlExample;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ReadConfig;

public class HandleAlert2 extends BaseTest {
	
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
		driver.get("file:///D:/Test.html");
		driver.manage().window().maximize();
		
	}
	
	@AfterTest
	public void closeApp() throws Exception {
		
		Thread.sleep(5000);
		driver.close();
		System.out.println("closing application");
	}
	
	
	
	
	
	@Test
	public void handlePromptAlert() throws Exception {
		
		Thread.sleep(3000);
		//generate an alert
		driver.findElement(By.xpath("//button[contains(text(),'Pro')]")).click();
		
		Thread.sleep(3000);
		//Alert/frame/windows    ------- driver.switchTo().
		
		//handle alert
		//accept/dismiss/getText/sendKeys
		
		Alert promptAlert = driver.switchTo().alert();
		
		System.out.println("Alert Text: " + promptAlert.getText());
		
		
		String name = "Rupal";
		
		//validation step
		Assert.assertEquals(promptAlert.getText(),"Please enter your name:");
		
		Assert.assertTrue(promptAlert.getText().contains("enter your name"));
		
		
		
		promptAlert.sendKeys(name);
		
		
		promptAlert.accept();
		
		
		//validation Step
		String validateLabel = driver.findElement(By.id("demoPrompt")).getText();
		System.out.println(validateLabel);
		Assert.assertTrue(validateLabel.contains(name));
	}
	

}
