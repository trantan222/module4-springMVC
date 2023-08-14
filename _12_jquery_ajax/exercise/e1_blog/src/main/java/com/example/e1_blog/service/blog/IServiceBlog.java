package com.example.e1_blog.service.blog;


import com.example.e1_blog.model.Blog;
import com.example.e1_blog.model.category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceBlog {
    Page<Blog> findAll(Pageable pageable);
    List<Blog> findAll();
    Page<Blog> searchName(Pageable pageable,String searchName);
    Blog findById(Integer id);
    void save(Blog blog);
    void delete(Integer id);
    Page<Blog> findBlogByAuthorContaining(String author,Pageable pageable);
    Page<Blog> findAllByCategory(category category, Pageable pageable);
    List<Blog> findAllByCategory(category category);
    List<Blog> findBlogByCategory_Id (Integer id);

}
