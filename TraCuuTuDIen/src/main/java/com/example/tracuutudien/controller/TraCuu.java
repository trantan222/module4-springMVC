package com.example.tracuutudien.controller;

import com.example.tracuutudien.repository.TuDienMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TraCuu {
        final TuDienMap map;
    public TraCuu(TuDienMap map) {
        this.map = map;
    }


    @GetMapping("/show")
    public String show(Model model)
    {
        model.addAttribute("map",map.getAll());
        return "list";
    }
    @GetMapping("/show/create")
    public String showFormCreate(){
        return "create";
    }
    @PostMapping("/show/create")
    public String add(@RequestParam("word") String word, @RequestParam("translate") String translate,Model model){
            map.addWordToDictionary(word,translate);
            model.addAttribute("message", "Add Successful!!");
        model.addAttribute("map",map.getAll());
        return "list";
    }

    @PostMapping ("/show/search")
    public String search(@RequestParam("word") String name , ModelMap modelMap){
        if( map.find(name) != null){
            modelMap.addAttribute("map",map.find(name));
            return "search";
        }
        return "list";
    }
}
