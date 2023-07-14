package com.example.sudungthymeleafdequanlisanpham.service;

import com.example.sudungthymeleafdequanlisanpham.model.product;
import com.example.sudungthymeleafdequanlisanpham.repo.ProductImpl;
import com.example.sudungthymeleafdequanlisanpham.repo.RepoProduct;

import java.util.List;

public class ProductServiceImpl implements ServiceProduct{
    RepoProduct products = new ProductImpl();
    @Override
    public List<product> findAll() {
        return products.findAll();
    }

    @Override
    public void save(product product) {
        products.save(product);
    }

    @Override
    public List<product> findbyName(String name) {
        return products.findbyName(name);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public void edit(int id, product product) {
        products.edit(id,product);
    }

    @Override
    public product detail(int id) {
        return products.detail(id);
    }
}
