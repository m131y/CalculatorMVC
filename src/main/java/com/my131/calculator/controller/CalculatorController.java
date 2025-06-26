package com.my131.calculator.controller;

import com.my131.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CalculatorController {
    private final CalculatorService calculatorService;

    @Autowired
    //private final인 calculatorservice를 설정할 수 있게 함
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }
}
