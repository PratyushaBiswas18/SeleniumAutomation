package testNGexample;

import org.testng.annotations.Test;

public class TestNGExample {
	
	
	//Priority  ------ 
	//by default priority is 0
	//if priority is same , execution as per alphabetic order --- ascii value
	//highest negative number having highest priority 
	
	
	@Test(priority = 1)
	public void login() {
		
		System.out.println("login test case");
		
	}
	
	@Test(priority = 3)
	public void logout() {
		
		System.out.println("logout test case");
		
	}
	
	@Test(priority = 2)
	public void addItems() {
		
		System.out.println("addItems test case");
		
	}
	
	
	@Test(priority = 2)
	public void payment() {
		
		System.out.println("payment test case");
		
	}

}
