package com.example.demo.repo;

import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoEmployee extends JpaRepository<Employee,Integer> {
}
