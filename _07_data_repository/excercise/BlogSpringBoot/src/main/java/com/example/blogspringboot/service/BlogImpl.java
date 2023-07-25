package com.example.blogspringboot.service;

import com.example.blogspringboot.model.Blog;
import com.example.blogspringboot.repository.IBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogImpl implements IServiceBlog {
    final
    IBlog iBlog ;

    public BlogImpl(IBlog iBlog) {
        this.iBlog = iBlog;
    }
    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlog.findAll(pageable);
    }
}
