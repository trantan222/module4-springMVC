package com.example.blogspringboot.controller;

import com.example.blogspringboot.model.Blog;
import com.example.blogspringboot.service.IServiceBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BlogController {
    final
    IServiceBlog iServiceBlog;
    public BlogController(IServiceBlog iServiceBlog) {
        this.iServiceBlog = iServiceBlog;
    }
    @GetMapping("")
    public String show(@PageableDefault(value = 3) Pageable pageable,Model model){
          Page<Blog> blogs =iServiceBlog.findAll(pageable);
          model.addAttribute("blog",blogs);
          return "list";
    }


}
