package controlExample;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;

public class HandleCheckboxradioButton extends BaseTest {
	
	
	@Test
	public void handleCheckbox() {
		System.out.println("handleCheckbox");
		driver.findElement(By.xpath("//input[@value='Boat']")).click();
	}
	
	@Test
	public void handleradioButton() {
		System.out.println("handleradioButton");
		driver.findElement(By.xpath("//input[contains(@value,'fem')]")).click();
	}

}
