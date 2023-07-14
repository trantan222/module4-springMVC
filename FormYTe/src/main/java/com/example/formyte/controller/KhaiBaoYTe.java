package com.example.formyte.controller;

import com.example.formyte.model.ToKhai;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KhaiBaoYTe {
    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("toKhai", new ToKhai());
        return "list";
    }
}
