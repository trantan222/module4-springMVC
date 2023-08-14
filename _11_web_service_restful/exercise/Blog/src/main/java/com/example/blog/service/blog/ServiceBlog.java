package com.example.blog.service.blog;


import com.example.blog.model.Blog;
import com.example.blog.model.category;
import com.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceBlog implements IServiceBlog {
    private final IBlogRepository repo;

    public ServiceBlog(IBlogRepository repo) {
        this.repo = repo;
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public List<Blog> findAll() {
        return repo.findAll();
    }

    @Override
    public Page<Blog> searchName(Pageable pageable,String author) {
        return repo.findBlogByAuthorContaining(pageable,author);
    }

    @Override
    public Blog findById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
         repo.save(blog);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public Page<Blog> findBlogByAuthorContaining(String author, Pageable pageable) {
        return repo.findBlogByAuthorContaining(pageable,author);
    }

    @Override
    public Page<Blog> findAllByCategory(category category, Pageable pageable) {
        return repo.findAllByCategory(category,pageable);
    }

    @Override
    public List<Blog> findAllByCategory(category category) {
        return repo.findAllByCategory(category);
    }

    @Override
    public List<Blog> findBlogByCategory_Id(Integer id) {
        return repo.findBlogByCategory_Id(id);
    }


}
