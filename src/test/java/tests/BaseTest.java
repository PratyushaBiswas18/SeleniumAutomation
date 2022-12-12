package tests;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import utility.ReadConfig;

public class BaseTest {

	WebDriver driver;
	ReadConfig conf;
	Logger log;
	LoginPage lp;
	// ctrl+Shoift+O ----- autoimport
	// pre-condition ----- @BeforeSuite-----
	// Test
	// post-condition ----- @AfterSuite

	@BeforeTest
	public void launchApp() throws Exception {

		log = Logger.getLogger("NOP Comm Application Module");
		PropertyConfigurator.configure(".\\testData\\log4j.properties");

		log.info("launching application");
		// System.out.println("launching application");

		// create an Object on ReadConfig file
		conf = new ReadConfig();
		// System.out.println(conf.get_NOP_URL());
		log.info("Application URL: " + conf.get_NOP_URL());

		driver = WebDriverManager.chromedriver().create();
		driver.get(conf.get_NOP_URL());
		log.info("Application launched successfully into chrome browser " + conf.get_NOP_URL());
		// driver.get(conf.get_sampleApp_URL());
		driver.manage().window().maximize();

		// Create an Object
		
//		Actions act = new Actions(driver);
//		act.contextClick();
		
		lp = new LoginPage(driver);

	}

	@AfterTest
	public void closeApp() throws Exception {

		Thread.sleep(5000);
		driver.close();
		log.info("closing application");
		// System.out.println("closing application");
	}

}
