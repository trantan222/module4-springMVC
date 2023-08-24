package com.example.module2_accountname_wbe.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Education_degree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "varchar(45)")
    private String name;
    @OneToMany(mappedBy = "Education_degree",cascade = CascadeType.ALL)
    private List<Employee> employeeList;
    public Education_degree() {
    }
}
