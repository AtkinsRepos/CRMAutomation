package com.crmAutomation.util;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.crmAutomation.util.XLUtils;

public class DataProviderGenerator3 
{

	@DataProvider(name = "INvalidSignUpData3")
	public static String[][] getSignUpData3() throws IOException {
		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\NwComp_3.xlsx";

		int rownum = XLUtils.getRowCount(path, "InvalidSignUp2");
		int colcount = XLUtils.getCellCount(path, "InvalidSignUp2", 1);

		String signUpData[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				signUpData[i - 1][j] = XLUtils.getCellData(path, "InvalidSignUp2", i, j);
			}
		}

		return signUpData;

	}
	
}
