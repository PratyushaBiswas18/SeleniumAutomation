package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddCustomerTest {
	
	
	@Test
	public void addCustName() {
		
		System.out.println("addCustName");
	}

	
	@Test
	public void addCustEmail() {
		
		System.out.println("addCustEmail");
	}
	
	
	@Test
	public void addCustFullName() {
		
		System.out.println("addCustFullName");
	}
	
	@Test
	public void addCustFullName2() {
		
		System.out.println("addCustFullName2");
		Assert.assertTrue(false);
	}
}
