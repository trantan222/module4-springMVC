package com.example.blog1.service;

import com.example.blog1.model.Blog;
import com.example.blog1.repository.IBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogService implements IBlogService{
    @Autowired
    IBlogRepo iBlogRepo;
    @Override
    public List<Blog> findAll() {
        return iBlogRepo.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return iBlogRepo.findById(id);
    }

    @Override
    public void save(Blog t) {
        iBlogRepo.save(t);
    }

    @Override
    public void remove(Long id) {
        iBlogRepo.remove(id);
    }
}
