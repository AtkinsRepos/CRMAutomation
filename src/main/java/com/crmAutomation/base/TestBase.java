package com.crmAutomation.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crmAutomation.util.TestUtil;
import com.crmAutomation.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;

	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	public static Logger logger;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")
			+"\\src\\main\\java\\com\\crmAutomation\\config\\config.properties");
		
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	@BeforeSuite
	public void initialization() {
	
			String browserName = prop.getProperty("browser");

			if (browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") 
						+"\\src\\test\\resources\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserName.equals("FF")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir")
						+"\\src\\test\\resources\\Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();

			}
			e_driver = new EventFiringWebDriver(driver);
			// Now create object of EventListerHandler to register it with
			// EventFiringWebDriver
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(com.crmAutomation.util.TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(com.crmAutomation.util.TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

			driver.get(prop.getProperty("url"));
			logger=Logger.getLogger("CRMAutomation");
			PropertyConfigurator.configure("Log4j.properties");

		

		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReportResults/myReport_"
+ TestUtil.getCurrentDateTime() + ".html");

		htmlReporter.config().setDocumentTitle("Automation Report");// Title of the report
		htmlReporter.config().setReportName("Functional Report");// Name of the report
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("Hostname", "LocalHost");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Tester Name", "ATKINS");
		extent.setSystemInfo("Browser", "Chrome");

	}
   
	
//	//@AfterSuite
//	@AfterMethod
//	public void tearDown() {
//		driver.close();	
//	}
	

		
		
		
//	public void tearDown(ITestResult result) throws IOException {
//		
//		if (result.getStatus() == ITestResult.FAILURE) {
//			test.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.takeScreenshotAtEndOfTest(driver)).build());
//			extent.flush();
//			driver.close();
//		} 
//		else if (result.getStatus() == ITestResult.SUCCESS) 
//		    
//			 {
//				test.pass("Test PASSED",MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.takeScreenshotAtEndOfTest(driver)).build());
//		      } 
//			 
//			 else if (result.getStatus() == ITestResult.SKIP)
//				 
//			 
//			 {	
//				 test.skip("Test Skipped",MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.takeScreenshotAtEndOfTest(driver)).build());
//			 }
//				 test.info("AfterMethod has fininshed runing Driver quite for the test initiated is Starting");
//			
//			 	
//	extent.flush();
//	driver.quit();
//	} 
	
	
	
	
	
		

}		
	
