package com.example.sudungthymeleafdequanlisanpham.service;

import com.example.sudungthymeleafdequanlisanpham.model.product;

import java.util.List;

public interface ServiceProduct {
    List<product> findAll();
    void save(product product);
    List<product> findbyName(String name);
    void remove(int id);
    void edit(int id,product product);
    product detail(int id);
}
