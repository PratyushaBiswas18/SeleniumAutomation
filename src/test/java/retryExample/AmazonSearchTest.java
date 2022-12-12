package retryExample;

import org.testng.annotations.Test;

public class AmazonSearchTest {
	
	@Test
	public void loginTest() {
		
		System.out.println("loginTest");
	}
	
	@Test
	public void logoutTest() {
		
		System.out.println("logouTest");
	}
	
	
	//@Test(retryAnalyzer = RetryLogic.class)
	@Test
	public void payment() {
		
		System.out.println("payment");
		int x = 10/0;
		
	}
	
	@Test
	public void addItemTest() {
		
		System.out.println("addItemTest");
	}

}
