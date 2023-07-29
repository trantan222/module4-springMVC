package com.example.blogspringboot.controller;

import com.example.blogspringboot.model.Blog;
import com.example.blogspringboot.model.category;
import com.example.blogspringboot.repository.ICateGoryRepository;
import com.example.blogspringboot.service.blog.IServiceBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    final
    IServiceBlog iServiceBlog;
    final
    ICateGoryRepository iCateGoryRepository;

    public BlogController(IServiceBlog iServiceBlog, ICateGoryRepository iCateGoryRepository) {
        this.iServiceBlog = iServiceBlog;
        this.iCateGoryRepository = iCateGoryRepository;
    }

    @GetMapping("")
    public String show(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "2") int size,
                       @RequestParam("author")Optional<String> author,Model model)
    {
        String authorValue ="";
        if (author.isPresent()){
            authorValue = author.get();
        }
        Pageable pageable = PageRequest.of(page,size, Sort.by("date").ascending().and(Sort.by("id").ascending()));
        Page<Blog> blogs = iServiceBlog.searchName(pageable,authorValue);
        List<category> categories =iCateGoryRepository.findAll();
        model.addAttribute("categories",categories);
        model.addAttribute("blogs",blogs);
        return "/blog/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        List<category> categories =iCateGoryRepository.findAll();
        model.addAttribute("categories",categories);
        model.addAttribute("blog", new Blog());
        return "/blog/create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute("blog") Blog blog,
                         Model model){
        iServiceBlog.save(blog);
        model.addAttribute("blogs",blog);
        model.addAttribute("message"," create successufull!!!");
        return "redirect:/blogs";
    }
    @GetMapping("/search")
    public String search(@RequestParam("author") String author,
                         @PageableDefault(size = 2,direction = Sort.Direction.ASC) Pageable pageable,
                         Model model) {
        List<category> categories =iCateGoryRepository.findAll();
        Page<Blog> blogs = iServiceBlog.findBlogByAuthorContaining(author,pageable);
        model.addAttribute("categories",categories);
        model.addAttribute("blogs", blogs);
        return "/blog/list";
    }
    @GetMapping("/searchCategory")
    public String searchCategory(@RequestParam("catego") category catego,
                         @PageableDefault(size = 2,direction = Sort.Direction.ASC) Pageable pageable,
                         Model model) {
        List<category> categories =iCateGoryRepository.findAll();
        Page<Blog> blogs = iServiceBlog.findAllByCategory(catego,pageable);
        model.addAttribute("categories",categories);
        model.addAttribute("blogs", blogs);
        return "/blog/list";
    }
    @GetMapping("/edit/{id}")
    public String showUp(@PathVariable Integer id,Model model){
        Blog blog = iServiceBlog.findById(id);
        List<category> categories =iCateGoryRepository.findAll();
        model.addAttribute("categories",categories);
        model.addAttribute("blog",blog);
        return "/blog/update";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute("blog") Blog blog,
                       Model model){
        iServiceBlog.save(blog);
        model.addAttribute("blogs",blog);
        model.addAttribute("message"," update success!!!");
        return "redirect:/blogs";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model) {
      iServiceBlog.delete(id);
      return "redirect:/blogs";
    }

}
