package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.category;
import com.example.blog.service.blog.IServiceBlog;
import com.example.blog.service.categoryy.IServiceCategory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class RestController {
    final
    IServiceBlog iServiceBlog;
    final
    IServiceCategory Servicecategory;

    public RestController(IServiceBlog iServiceBlog, IServiceCategory Servicecategory) {
        this.iServiceBlog = iServiceBlog;
        this.Servicecategory = Servicecategory;
    }
    @GetMapping("/blog")
    public ResponseEntity<List<Blog>> ListBlog(){
        List<Blog> blogs = iServiceBlog.findAll();
        if(blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }
    @GetMapping("/category")
    public ResponseEntity<List<category>> listCategory(){
        List<category> categories = Servicecategory.findAll();
        if(categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<List<Blog>> listBlogByCategory(@PathVariable("id") Integer id){
       List<Blog> blogs = iServiceBlog.findBlogByCategory_Id(id);
        if(blogs == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }
    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> BlogDetail(@PathVariable("id") Integer id){
        Blog blog = iServiceBlog.findById(id);
        if(blog == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
}
