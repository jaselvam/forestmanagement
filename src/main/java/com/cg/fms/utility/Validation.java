package com.cg.fms.utility;

public class Validation {
	
	// The below format of regular expression states that the attribute should have 
	//atleast one capital letter, one small letter and minimum of one digit to match this regular expression
	// and minimum of 8 characters.
	
	public static String regex="(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}";
}
