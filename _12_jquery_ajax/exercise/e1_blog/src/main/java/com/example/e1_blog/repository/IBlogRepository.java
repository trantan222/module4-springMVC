package com.example.e1_blog.repository;


import com.example.e1_blog.model.Blog;
import com.example.e1_blog.model.category;
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
    List<Blog> findAllByCategory(category category);
    Page<Blog> findBlogByAuthorContaining(Pageable pageable, String author);
    List<Blog> findBlogByCategory_Id (Integer id);
}
