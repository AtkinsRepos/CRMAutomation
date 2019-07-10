package com.crmAutomation.util;

import org.testng.annotations.DataProvider;

public class DataProviderTesting {
	
	XLUtils utils=new XLUtils();
	
	@DataProvider(name = "test")
	
	public Object[][] getSignUpData() {
		Object[][] testData = null;
		try {
			testData = utils.getTestData("INvalidSignUp","Test", "Yes");
		} catch (Exception e) {
   
			e.printStackTrace();
		
		
		
		}
		return testData;
	}
	
	
@DataProvider(name = "test1")
	
	public Object[][] getSignUpData1() {
		Object[][] testData = null;
		try {
			testData = utils.getTestData("validSignUp","Test", "Yes");
		} catch (Exception e) {
   
			e.printStackTrace();
		
		
		
		}
		return testData;
	}
@DataProvider(name = "test3")
public Object[][] getSignUpData2() {
	Object[][] testData = null;
	try {
		testData = utils.getTestData("INvalidContinuationData","Test", "Yes");
	} catch (Exception e) {

		e.printStackTrace();
	
	
	
	}
	return testData;
}



@DataProvider(name = "test4")
public Object[][] getSignUpData3() {
	Object[][] testData = null;
	try {
		testData = utils.getTestData("NewCompny","Test", "Yes");
	} catch (Exception e) {

		e.printStackTrace();
	
	
	
	}
	return testData;
}
@DataProvider(name = "test5")
public Object[][] getSignUpData5() {
	Object[][] testData = null;
	try {
		testData = utils.getTestData("NewContact","Test", "Yes");
	} catch (Exception e) {

		e.printStackTrace();
	
	
	
	}
	return testData;
}


}