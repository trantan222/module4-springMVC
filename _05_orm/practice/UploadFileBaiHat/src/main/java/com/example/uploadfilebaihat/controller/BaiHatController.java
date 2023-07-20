package com.example.uploadfilebaihat.controller;

import com.example.uploadfilebaihat.model.BaiHat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class BaiHatController {
    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("baiHat",new BaiHat());
        return "upload";
    }
    @PostMapping("/upload")
    public String upload(@ModelAttribute("baiHat") BaiHat baiHat, Model model){

        return "view";
    }
}
