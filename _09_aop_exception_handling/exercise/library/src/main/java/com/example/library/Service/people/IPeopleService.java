package com.example.library.Service.people;

import com.example.library.model.People;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPeopleService {
    Page<People> findAll(Pageable pageable);
    People create(People people);
    void delete(Integer id);
    People findById(Integer id);
}
