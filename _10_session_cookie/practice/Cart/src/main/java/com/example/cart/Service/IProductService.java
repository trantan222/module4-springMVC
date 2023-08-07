package com.example.cart.Service;

import com.example.cart.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
     List<Product> FindAll();
     Product findById(Long id);
     void Save(Product product);
     void delete(Long id);
     Optional<Product> findById2(Long id);
}
