package com.gaming.testso.gaming.services.validation;

public class AppStringUtils {
	public static String join(String action, String option) {
		return String.join(":", action, option.isEmpty()?"":option);
		
	}

}
