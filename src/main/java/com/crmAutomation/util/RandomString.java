package com.crmAutomation.util;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomString {
	 //generating random string for fields that must change value at the point of data entry eg username, emails, pwd, DOB etc. a very useful utility.
	  public static String randomestring() {
			String generatedString1 = RandomStringUtils.randomAlphabetic(8);
			return (generatedString1);
		}

		public static String randomeNum() {
			String generatedString2 = RandomStringUtils.randomNumeric(4);
			return (generatedString2);
		}
		
		public static String randomeAlphaNumeral() {
			String randomeAlphaNumera = RandomStringUtils.randomAlphanumeric(8);
			return (randomeAlphaNumera);
		}

}
