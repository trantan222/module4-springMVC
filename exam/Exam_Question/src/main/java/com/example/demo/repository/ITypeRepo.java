package com.example.demo.repository;

import com.example.demo.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeRepo extends JpaRepository<Type,Integer> {
}
