package com.example.blog1.repository;

import com.example.blog1.model.Blog;

import java.util.List;

public interface IBlogRepo  {
    List<Blog> findAll();

    Blog findById(Long id);

    void save(Blog t);

    void remove(Long id);

}
