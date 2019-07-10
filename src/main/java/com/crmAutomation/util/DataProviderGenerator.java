package com.crmAutomation.util;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.crmAutomation.util.XLUtils;

public class DataProviderGenerator 
{

	@DataProvider(name = "SignUpData")
	public static String[][] getSignUpData() throws IOException {
		String path = System.getProperty("user.dir") + "//src//test//resources//TestData//NwComp_3.xlsx";

		int rownum = XLUtils.getRowCount(path, "SignUp");
		int colcount = XLUtils.getCellCount(path, "SignUp", 1);
		
		String signUpData[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				signUpData[i - 1][j] = XLUtils.getCellData(path, "SignUp", i, j);
		}
	}

		return signUpData;
		
	}
	
	@DataProvider(name = "INvalidSignUpData2")
	public static Object[][] getSignUpData2() throws IOException {
		String path = System.getProperty("user.dir") + "//src//test//resources//TestData//NwComp_3.xlsx";

		int rownum = XLUtils.getRowCount(path, "INvalidSignUp");
		int colcount = XLUtils.getCellCount(path, "INvalidSignUp", 1);

		String signUpData[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				signUpData[i - 1][j] = XLUtils.getCellData(path, "INvalidSignUp", i, j);
			}
		}

		return signUpData ;

	}
//	@DataProvider(name = "INvalidSignUpData3")
//	public static String[][] getSignUpData3() throws IOException {
//		String path = System.getProperty("user.dir") + "//src//test//resources//TestData//NwComp_3.xlsx";
//
//		int rownum = XLUtils.getRowCount(path, "INvalidSignUp2");
//		int colcount = XLUtils.getCellCount(path, "INvalidSignUp2", 1);
//
//		String signUpData[][] = new String[rownum][colcount];
//
//		for (int i = 1; i <= rownum; i++) {
//			for (int j = 0; j < colcount; j++) {
//				signUpData[i - 1][j] = XLUtils.getCellData(path, "INvalidSignUp2", i, j);
//			}
//		}
//
//		return signUpData;
//
//	}
	
}
