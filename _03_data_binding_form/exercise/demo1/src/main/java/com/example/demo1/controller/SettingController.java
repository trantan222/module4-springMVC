package com.example.demo1.controller;

import com.example.demo1.model.Setting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SettingController {
    @GetMapping("/")
    public ModelAndView show(){
        ModelAndView modelAndView = new ModelAndView("setting","setting",new Setting());
        return modelAndView;
    }
    @PostMapping("/update")
    public String create(@ModelAttribute("Setting") Setting setting, Model model){
        model.addAttribute("languege",setting.getLanguege());
        model.addAttribute("pageSize",setting.getPageSize());
        model.addAttribute("spamFilter",setting.getSpamFilter());
        model.addAttribute("signnature",setting.getSignnature());
        return "view";
    }
}
