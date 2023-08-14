package com.example.e1_blog.service.categoryy;


import com.example.e1_blog.model.category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceCategory {
    Page<category> findAll(Pageable pageable, String name);
    List<category> findAll();
    category findById(Integer id);
    boolean save(category category);
    void delete(Integer id);

}
