package com.example.uploadbaihat.controller;

import com.example.uploadbaihat.model.BaiHat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BaiHatController {


    @GetMapping("/")
public String showForm(Model model){
    model.addAttribute("baiHat",new BaiHat());
    return "upload";
}
@PostMapping("/upload")
public String upload(@ModelAttribute("baiHat") BaiHat baiHat,Model model){
        model.addAttribute("name",baiHat.getTen());
        model.addAttribute("nghesi",baiHat.getNgheSi());
        model.addAttribute("TheLoai",baiHat.getTheLoai());
        return "view";
}


}
