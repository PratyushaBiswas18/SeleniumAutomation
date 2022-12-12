package nopComm;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ReadConfig;

public class BaseTest {
	
	
	
	WebDriver driver;
	ReadConfig conf;
	//ctrl+Shoift+O ----- autoimport
	//pre-condition    ----- @BeforeSuite-----
	//Test
	//post-condition   ----- @AfterSuite
	
	
	@BeforeTest
	public void launchApp() throws Exception {
		
		System.out.println("launching application");
		
		
		//create an Object on ReadConfig file
		conf = new ReadConfig();
		System.out.println(conf.get_NOP_URL());
		
		
		driver = WebDriverManager.chromedriver().create();
		driver.get(conf.get_NOP_URL());
		//driver.get(conf.get_sampleApp_URL());
		driver.manage().window().maximize();
		
	}
	
	@AfterTest
	public void closeApp() throws Exception {
		
		Thread.sleep(5000);
		driver.close();
		System.out.println("closing application");
	}

}
