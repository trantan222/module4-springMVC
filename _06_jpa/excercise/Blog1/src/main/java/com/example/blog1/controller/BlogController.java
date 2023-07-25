package com.example.blog1.controller;

import com.example.blog1.model.Blog;
import com.example.blog1.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {
    private final IBlogService iBlogService;

    public BlogController(IBlogService iBlogService) {
        this.iBlogService = iBlogService;
    }
    @GetMapping("/")
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("blog",iBlogService.findAll());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("blog",new Blog());
        return modelAndView;
    }
    @PostMapping("/create")
    public String saveCustomer(@ModelAttribute("blog") Blog blog,Model model) {
        iBlogService.save(blog);
        model.addAttribute("blog", new Blog());
        model.addAttribute("message", "New customer created successfully");
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showUp(@PathVariable Long id){
        Blog blog = iBlogService.findById(id);
        if (blog != null){
            ModelAndView modelAndView = new ModelAndView("/edit");
            modelAndView.addObject("blog", blog);
            return modelAndView;
        }else{
            ModelAndView modelAndView = new ModelAndView("/error404");
            return modelAndView;
        }
    }
    @PostMapping("/edit")
    public String updateCustomer(@ModelAttribute("blog") Blog blog,Model model) {
        iBlogService.save(blog);
        model.addAttribute("blog", blog);
        model.addAttribute("message", " updated successfully");
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        iBlogService.remove(id);
        return "redirect:/";
    }

}
