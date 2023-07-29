package com.example.blogspringboot.controller;

import com.example.blogspringboot.model.category;
import com.example.blogspringboot.service.categoryy.IServiceCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {
    final
    IServiceCategory categories;

    public CategoryController(IServiceCategory categories) {
        this.categories = categories;
    }

    @GetMapping
    public String showCategoryList(Model model){
        model.addAttribute("categories",categories.findAll());
        return "/category/list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("category",new category());
        return "/category/createOrUp";
    }
    @PostMapping("/create")
    public String create( @ModelAttribute("category") category category, Model model){
         categories.save(category);
         return "redirect:/category";
    }
    @GetMapping("/edit/{id}")
    public String showUp(@PathVariable("id") Integer id,Model model){
        category category = categories.findById(id);
        model.addAttribute("category",category);
        return "/category/createOrUp";
    }
    @GetMapping("/delete/{id}")
    public String Delete(@PathVariable("id") Integer integer){
        categories.delete(integer);
        return "redirect:/category";
    }
}
