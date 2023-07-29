package com.example.blogspringboot.repository;

import com.example.blogspringboot.model.Blog;
import com.example.blogspringboot.model.category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    @Query(value = "select * from Blog where author like :author",nativeQuery = true)
    List<Blog> searchBlogByAuthor(@Param("author") String author);
    Page<Blog> findAllByCategory(category category, Pageable pageable);
    Page<Blog> findBlogByAuthorContaining(Pageable pageable, String author);
}
