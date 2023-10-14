package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.repo.RepoEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    RepoEmployee repoEmployee;
    @GetMapping("")
    public String list(Model model){
        List<Employee> employees = repoEmployee.findAll();
        model.addAttribute("employees",employees);
        return "view";
    }
    @GetMapping("/{id}")
    public String view(@PathVariable Integer id, Model model){
        model.addAttribute("e",repoEmployee.findById(id));
        return "view";
    }
}
