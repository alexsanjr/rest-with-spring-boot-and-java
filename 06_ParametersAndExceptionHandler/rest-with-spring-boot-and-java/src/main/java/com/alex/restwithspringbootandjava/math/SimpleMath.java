package com.alex.restwithspringbootandjava.math;

public class SimpleMath {

	public static Double sum(Double num1, Double num2) {
		return num1 + num2;
	}

	public static Double sub(Double num1, Double num2) {

		return num1 - num2;
	}

	public static Double mult(Double num1, Double num2) {

		return num1 * num2;
	}

	public static Double div(Double num1, Double num2) {
		return num1 / num2;
	}

	public static Double avg(Double num1, Double num2) {
		return (num1 + num2) / 2;
	}

	public static Double sqr(Double num) {
		return Math.sqrt(num);
	}
}
