package com.example.blogspringboot.repository;

import com.example.blogspringboot.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IBlog extends JpaRepository<Blog,Integer> {
}
