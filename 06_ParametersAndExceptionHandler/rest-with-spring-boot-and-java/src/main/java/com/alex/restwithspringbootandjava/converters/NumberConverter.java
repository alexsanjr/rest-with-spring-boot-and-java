package com.alex.restwithspringbootandjava.converters;

import com.alex.restwithspringbootandjava.exceptions.UnsupportedMathOperationException;

public class NumberConverter {
	
	public static void verifyNumeric(String num1, String num2) {
		if (!isNumeric(num1) || !isNumeric(num2)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
	}

	public static boolean isNumeric(String strNum) {
		if (strNum == null)
			return false;
		String number = strNum.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

	public static Double convertToDouble(String strNum) {
		if (strNum == null)
			return 0D;

		String number = strNum.replaceAll(",", ".");
		if (isNumeric(number))
			return Double.parseDouble(number);

		return 0D;
	}
}
