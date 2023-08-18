package com.example.e1_blog.controller;

import com.example.e1_blog.model.Blog;
import com.example.e1_blog.model.category;
import com.example.e1_blog.service.blog.IServiceBlog;
import com.example.e1_blog.service.categoryy.IServiceCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class RestController {
    final
    IServiceBlog iServiceBlog;
    final
    IServiceCategory category;

    public RestController(IServiceBlog iServiceBlog, IServiceCategory category) {
        this.iServiceBlog = iServiceBlog;
        this.category = category;
    }
    @GetMapping("")
    public ResponseEntity<Page<Blog>> show(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "2") int size,
                               @RequestParam("author") Optional<String> author, Model model)
    {
        String authorValue ="";
        if (author.isPresent()){
            authorValue = author.get();
        }
        Pageable pageable = PageRequest.of(page,size, Sort.by("date").ascending().and(Sort.by("id").ascending()));
        Page<Blog> blogs = iServiceBlog.searchName(pageable,authorValue);
        List<category> categories =category.findAll();
        model.addAttribute("categories",categories);
        model.addAttribute("blogs",blogs);
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
    @GetMapping("/search")
    public String search(@RequestParam("author") String author,
                         @PageableDefault(size = 2,direction = Sort.Direction.ASC) Pageable pageable,
                         Model model) {
        List<category> categories =category.findAll();
        Page<Blog> blogs = iServiceBlog.findBlogByAuthorContaining(author,pageable);
        model.addAttribute("categories",categories);
        model.addAttribute("blogs", blogs);
        return "/blog/list";
    }
}
