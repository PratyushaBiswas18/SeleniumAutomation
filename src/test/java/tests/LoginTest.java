package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
	
	
	@Test
	public void verifyLoginFeature() throws Exception {
		
		Thread.sleep(3000);
		//before login application title should be
		log.info("before login application title should be" + driver.getTitle());
		lp.verificationOfApplicationTitle("Your store. Login");
		
		log.info("enter userName");
		lp.enterEmail(conf.get_adminuser());
		log.info("enter password");
		lp.enterPass(conf.get_adminPass());
		log.info("click on radio checkbox");
		lp.clickCheckboxRem();
		log.info("click on login button");
		lp.clickLoginButton();
		
		
		Thread.sleep(3000);
		log.info("after login application title should be" + driver.getTitle());
		lp.verificationOfApplicationTitle("Dashboard / nopCommerce administration");

	}
	
	@Test
	public void verifyLogoutTest() {
		
		Assert.assertTrue(false);
	}

}
