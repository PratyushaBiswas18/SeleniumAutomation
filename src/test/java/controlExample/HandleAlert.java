package controlExample;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class HandleAlert extends BaseTest {
	
	
	@Test
	public void handleSimpleAlert() throws Exception {
		
		Thread.sleep(3000);
		//generate an alert
		driver.findElement(By.xpath("//input[contains(@value,'Show')]")).click();
		
		Thread.sleep(3000);
		//Alert/frame/windows    ------- driver.switchTo().
		
		//handle alert
		//accept/dismiss/getText/sendKeys
		
		Alert simpleAlert = driver.switchTo().alert();
		
		System.out.println("Alert Text: " + simpleAlert.getText());
		
		//validation step
		Assert.assertEquals(simpleAlert.getText(),"Hi.. This is alert message!");
		
		Assert.assertTrue(simpleAlert.getText().contains("alert message"));
		
		//simpleAlert.accept();
		
		simpleAlert.dismiss();
		
	}
	
	
	@Test
	public void handleConfirmAlert() throws Exception {
		
		Thread.sleep(3000);
		//generate an alert
		driver.findElement(By.xpath("//button[contains(text(),'Confirmation')]")).click();
		
		Thread.sleep(3000);
		//Alert/frame/windows    ------- driver.switchTo().
		
		//handle alert
		//accept/dismiss/getText/sendKeys
		
		Alert confirmAlert = driver.switchTo().alert();
		
		System.out.println("Alert Text: " + confirmAlert.getText());
		
		//validation step
		Assert.assertEquals(confirmAlert.getText(),"Press 'OK' or 'Cancel' button!");
		
		Assert.assertTrue(confirmAlert.getText().contains("'OK' or 'Cancel'"));
		
		confirmAlert.accept();
		
		
		
		//confirmAlert.dismiss();
		Thread.sleep(3000);
		String pressOk_cancel = driver.findElement(By.xpath("//*[@id='demo']")).getText();
		System.out.println(pressOk_cancel);
		//validation step
		Assert.assertEquals(pressOk_cancel,"You pressed OK!");
		Assert.assertTrue(pressOk_cancel.contains("OK"));
		
		
		
		
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
		
		//validation step
		Assert.assertEquals(promptAlert.getText(),"Your Name Please");
		
		Assert.assertTrue(promptAlert.getText().contains("Name Please"));
		
		
		
		promptAlert.sendKeys("abhishek.....");
		
		
		promptAlert.accept();
		
		
		
		
	}
	

}
