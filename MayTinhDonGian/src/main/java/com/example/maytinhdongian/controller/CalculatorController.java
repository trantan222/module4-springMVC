package com.example.maytinhdongian.controller;

import com.example.maytinhdongian.model.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("")
    public String show(){
        return "list";
    }
    @PostMapping("/calculate")
    public String calculate(@RequestParam("first-operand") float n1,
                            @RequestParam("second-operand") float n2,
                            @RequestParam("operator") char operator,
                            Model model) {
        try {
            float result = Calculator.calculate(n1, n2, operator);
            model.addAttribute("result", result);
        } catch (Exception e) {
            model.addAttribute("message", "can not divide by zero");
            return "result";
        }
        return "result";
    }
}
