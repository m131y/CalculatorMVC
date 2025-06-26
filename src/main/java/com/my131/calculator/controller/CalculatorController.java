package com.my131.calculator.controller;

import com.my131.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    private final CalculatorService calculatorService;

    @Autowired
    //private final인 calculator service를 설정할 수 있게 함
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/")
    public String showCalculator() {
        return "calculator";
    }

    @PostMapping("/calculate") //calculate.html 의 form action과 연결
    public String calculate(
        @RequestParam("num1") double num1,
//        @RequestParam("num2") double num2,
//        @RequestParam("operation") String operation,
        Model model
    ) {
        System.out.println("clicked!");
        try {
            double result = calculatorService.calculate(num1, 10, "add");
            model.addAttribute("result", result);
        } catch(IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
        }
        return "calculator";
    }
}
