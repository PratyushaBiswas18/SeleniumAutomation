package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AddNewCustomer {

	WebDriver driver;

	public AddNewCustomer(WebDriver rdriver) {

		// this.driver = driver;
		driver = rdriver;
	}

	// indetification
	
	By txtEmail = By.id("Email");
	By txtPass = By.id("Password");
	By chkRem = By.xpath("//input[@name='RememberMe']");
	By btnLogin = By.tagName("button");
	
	
	

	// Methods

	public void enterEmail(String email) {

		driver.findElement(txtEmail).clear();
		driver.findElement(txtEmail).sendKeys(email);

	}

	
	public boolean verificationOfElementPresent(WebElement ele) {
		
		return ele.isDisplayed();
	}
	
	
	public void enterPass(String pwd) {

		driver.findElement(txtPass).clear();
		driver.findElement(txtPass).sendKeys(pwd);

	}

	public void clickCheckboxRem() {

		driver.findElement(chkRem).click();

	}

	public void clickLoginButton() {

		driver.findElement(btnLogin).click();


	}

	
	public void verificationOfApplicationTitle(String expectedValue) {
		
		Assert.assertEquals(driver.getTitle(), expectedValue);
		
		
	}
	
}
