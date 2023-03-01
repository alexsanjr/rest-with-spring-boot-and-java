package com.alex.restwithspringbootandjava;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

	private static final AtomicLong counter = new AtomicLong();

	@GetMapping("/sum/{num1}/{num2}")
	public Double sum(@PathVariable(value = "num1") String num1, @PathVariable(value = "num2") String num2)
			throws Exception {

		if (!isNumeric(num1) || !isNumeric(num2)) {
			throw new Exception();
		}
		return convertToDouble(num1) + convertToDouble(num2);
	}

	private Double convertToDouble(String strNum) {
		if (strNum == null) return 0D;
		
		String number = strNum.replaceAll(",", ".");
		if (isNumeric(number)) return Double.parseDouble(number);

		return 0D;
	}

	private boolean isNumeric(String strNum) {
		if (strNum == null) return false;
		String number = strNum.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
