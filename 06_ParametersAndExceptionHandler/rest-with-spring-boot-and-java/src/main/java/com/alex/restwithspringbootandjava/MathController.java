package com.alex.restwithspringbootandjava;

import org.springframework.web.bind.annotation.*;

import com.alex.restwithspringbootandjava.converters.NumberConverter;
import com.alex.restwithspringbootandjava.math.SimpleMath;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

	private static final AtomicLong counter = new AtomicLong();

	@GetMapping("/sum/{num1}/{num2}")
	public Double sum(@PathVariable(value = "num1") String num1, @PathVariable(value = "num2") String num2)
			throws Exception {
		NumberConverter.verifyNumeric(num1, num2);
		return SimpleMath.sum(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(num2));
	}

	@GetMapping("/sub/{num1}/{num2}")
	public Double sub(@PathVariable(value = "num1") String num1, @PathVariable(value = "num2") String num2)
			throws Exception {
		NumberConverter.verifyNumeric(num1, num2);
		return SimpleMath.sub(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(num2));
	}
	
	@GetMapping("/mult/{num1}/{num2}")
	public Double mult(@PathVariable(value = "num1") String num1, @PathVariable(value = "num2") String num2)
			throws Exception {
		NumberConverter.verifyNumeric(num1, num2);
		return SimpleMath.mult(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(num2));
	}
	
	@GetMapping("/div/{num1}/{num2}")
	public Double div(@PathVariable(value = "num1") String num1, @PathVariable(value = "num2") String num2)
			throws Exception {
		NumberConverter.verifyNumeric(num1, num2);
		return SimpleMath.div(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(num2));
	}
	
	@GetMapping("/avg/{num1}/{num2}")
	public Double avg(@PathVariable(value = "num1") String num1, @PathVariable(value = "num2") String num2)
			throws Exception {
		NumberConverter.verifyNumeric(num1, num2);
		return SimpleMath.avg(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(num2));
	}
	
	@GetMapping("/sqr/{num1}")
	public Double sqr(@PathVariable(value = "num1") String num)
			throws Exception {
		NumberConverter.verifyNumeric(num, "0");
		return SimpleMath.sqr(NumberConverter.convertToDouble(num));
	}

}
