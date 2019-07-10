package com.crmAutomation.testScripts;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crmAutomation.base.TestBase;
import com.crmAutomation.pageObjects.HomePage;
import com.crmAutomation.pageObjects.LoginPage;
import com.crmAutomation.util.TestUtil;

public class TemplateTest extends TestBase{
	
	
	HomePage homepage;
	LoginPage loginpage;
	TestUtil testutil;
	
	public TemplateTest()
	{
		super();
		
	}
		
		
		@BeforeMethod
		public void setup() {
			initialization();
			testutil=new TestUtil();
			loginpage=new LoginPage();
			homepage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
			
	}
		
		

		@Test(priority=1)	
		public void u() {
			    }
		
		@Test(priority=2)
		public void v() {
			
		}
		

		@Test(priority=3)	
		public void f() {
			    }
		
		@Test(priority=4)
		public void t() {
			
		}
		@Test(priority=1)	
		public void d() {
			    }
		
		@Test(priority=2)
		public void c() {
			
		}
		

		@Test(priority=3)	
		public void b() {
			    }
		
		@Test(priority=4)
		public void a() {
			
		}

		@AfterMethod
		public void teardown() {
			driver.quit();
		}

}
