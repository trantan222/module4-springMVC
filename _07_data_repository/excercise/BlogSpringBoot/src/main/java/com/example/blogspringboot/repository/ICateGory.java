package com.example.blogspringboot.repository;

import com.example.blogspringboot.model.category;
import org.springframework.data.repository.CrudRepository;

public interface ICateGory extends CrudRepository<category,Integer> {
}
