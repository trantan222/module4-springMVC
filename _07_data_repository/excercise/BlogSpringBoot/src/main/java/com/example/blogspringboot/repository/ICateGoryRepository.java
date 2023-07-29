package com.example.blogspringboot.repository;

import com.example.blogspringboot.model.Blog;
import com.example.blogspringboot.model.category;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
@Repository
public interface ICateGoryRepository extends JpaRepository<category,Integer> {
//    @Query(value = "select b from Blog b join category c on c.id = b.id_category where c.id = :id",nativeQuery = true)
//    List<Blog> searchcategoriesBy(@Param("id") Integer id);
//
//    Page<Blog> findBlogByAuthorContaining(Pageable pageable, String author);


}
