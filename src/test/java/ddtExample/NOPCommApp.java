package ddtExample;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NOPCommApp extends BaseTest{
    
    
    
    @Test(dataProvider = "sanityData")
    public void verifyLoginFeatureWithInValid(String email, String pwd) throws Exception {
        
        Thread.sleep(3000);
        log.info("enter email details: " + email);
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys(email);
        Thread.sleep(3000);
        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Password")).sendKeys(pwd);
        driver.findElement(By.xpath("//input[@name='RememberMe']")).click();
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(3000);
        
        //Validation setp - Login was unsuccessful
        
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
        Assert.assertTrue(pageSource.contains("Login was unsuccessful"));
        
    }
    
    
    @DataProvider
    public Object[][] sampleData() {
        
        
        Object [][] data = {{"Anusha@gmail.com","Demo@123"},{"Pratyusha@google.com","password@123"}, {"Surya@yahoo.com","random@123"}};
        return data;
        
    }
    
    @DataProvider
    public Object[][] sanityData() {
        
        
        Object [][] data = {{"Rupal@gmail.com","Demo@123"},{"Anusha1@gmail.com","Demo@123"},{"Pratyusha1@google.com","password@123"}, {"Surya1@yahoo.com","random@123"}};
        return data;
        
    }

}