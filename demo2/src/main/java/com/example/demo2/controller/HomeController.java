package com.example.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class HomeController {
    @GetMapping("/")
   public String show(){
       return "list";
   }

   @PostMapping("/choose")
   public String save(@RequestParam("condiment") String[] condiment,ModelMap Model) {
       if(condiment != null) {
           for (int i = 0; i <condiment.length ; i++) {
               Model.addAttribute("condiment", display(condiment));
           }
           return "success";
       }
       return "list";
   }
   public String[] display(String[] arr){
       return arr;
   }
}
