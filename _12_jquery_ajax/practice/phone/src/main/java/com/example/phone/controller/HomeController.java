package com.example.phone.controller;

import com.example.phone.service.ServicePhone;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
@AllArgsConstructor
public class HomeController {

    private final ServicePhone smartPhoneService;

    @GetMapping
    public ModelAndView getAllSmartphonePage() {
        return new ModelAndView("/list", "smartphones", smartPhoneService.findAll());
    }
}
