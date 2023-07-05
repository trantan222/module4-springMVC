package com.example.ungdungchuyendoitiente.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Calculation {

    @GetMapping("/list")
    public String showList(){
        return "list";
    }

    @PostMapping("/list/result")
    public String calculation(@RequestParam("n1") int number, Model model){
        int exchangeVND = 22000;
        int resultt = number * exchangeVND;
        model.addAttribute("results",resultt);
        return "result";
    }
}
