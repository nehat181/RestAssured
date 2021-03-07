package com.org.utils;

import org.testng.asserts.SoftAssert;

public class Assertion {

	static SoftAssert softAssertion=new SoftAssert();
	
	public static void assertEquals(String actual,String expected) {
		
	softAssertion.assertEquals(actual, expected);
	
	
	
	}
	
	public static void assertEquals(String actual,int expected) {
		
		softAssertion.assertEquals(actual, expected);
		
		
		
		}
	public static void assertAll() {
		
		softAssertion.assertAll();
		
		
		
		}

}
