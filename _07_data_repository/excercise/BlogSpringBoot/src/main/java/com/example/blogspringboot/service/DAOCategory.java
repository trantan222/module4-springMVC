package com.example.blogspringboot.service;

import com.example.blogspringboot.model.category;
import org.springframework.data.domain.Page;

public interface DAOCategory {
    Page<category>  findAll();

}
