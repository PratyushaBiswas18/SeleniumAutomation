package extentReportExample;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class GoogleTestExtentReport {

	public ExtentHtmlReporter htmlReport;
	public ExtentReports extent;
	public ExtentTest logger ;
	
	@BeforeTest
	public void startReport() {
		
		String date_num = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		System.out.println(date_num);
		//generate a report
		htmlReport = new ExtentHtmlReporter(".\\test-output\\extentReport\\IBM_RegressionAutomation_" + date_num +"_.html");
		
		
		//Custom Report
		extent = new ExtentReports();
		extent.attachReporter(htmlReport);
		
		extent.setSystemInfo("HostName", "Localhost");
		extent.setSystemInfo("Enviornment", "Production");
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("UserName", "Rajesh Singh");
		
		htmlReport.config().setDocumentTitle("IBM - Functional/API automation report");
		htmlReport.config().setReportName("Regression Report");
		htmlReport.config().setTheme(Theme.DARK);
		
		
	}
	
	
	@AfterTest
	public void endReport() {
		
		//report ended
		extent.flush();
		
	}
	
	@Test
	public void verifyAppTitle() {

		//pass
		logger = extent.createTest("Test case - verifyAppTitle");
		Assert.assertTrue(true);
		
	}
	
	
	@AfterMethod
	public void AfterMethod(ITestResult res) {
		
		System.out.println("--------------------AfterMethod--------------------------");
		System.out.println("TestCase Name: " + res.getName());
		System.out.println("Result Status: " + res.getEndMillis());
		
	}
	
	

	@Test
	public void verifyAppLogo() {

		//failed
		
		logger = extent.createTest("Test case - verifyAppLogo");
		logger.log(Status.FAIL, MarkupHelper.createLabel("****Test case - verifyAppLogo***", ExtentColor.RED));
		Assert.assertTrue(false);
		//logger.log(Status.FAIL, MarkupHelper.createLabel("****Test case - verifyAppLogo***", ExtentColor.RED));
	}

}
