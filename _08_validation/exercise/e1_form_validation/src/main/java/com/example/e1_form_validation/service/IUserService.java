package com.example.e1_form_validation.service;

import com.example.e1_form_validation.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    Page<User> findAll(Pageable pageable);
    void save(User user);
}
