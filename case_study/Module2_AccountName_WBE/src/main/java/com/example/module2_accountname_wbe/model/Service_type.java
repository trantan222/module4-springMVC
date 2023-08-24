package com.example.module2_accountname_wbe.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Service_type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Service_type_id;
    @Column(columnDefinition = "varchar(45)")
    private String Service_type_name;
    @OneToMany(mappedBy = "Service_type")
    List<Service> services;

    public Service_type() {
    }
}
