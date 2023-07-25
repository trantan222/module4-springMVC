package com.example.blogspringboot.service;

import com.example.blogspringboot.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceBlog {
    Page<Blog> findAll(Pageable pageable);



}
