package com.alex.restwithspringbootandjava;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

    private static final AtomicLong counter = new AtomicLong();

    @GetMapping("/sum/{num1}/{num2}")
    public Double sum(
            @PathVariable(value = "num1") String num1,
            @PathVariable(value = "num2") String num2) {
        return 2D;
    }
}
