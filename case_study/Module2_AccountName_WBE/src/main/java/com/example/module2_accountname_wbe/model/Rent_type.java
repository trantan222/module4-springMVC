package com.example.module2_accountname_wbe.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Rent_type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rent_type_id;
    @Column(columnDefinition = "varchar(45)")
    private String rent_type_name;
    private double rent_type_cost;
    @OneToMany(mappedBy = "Rent_type")
    List<Service> services;

    public Rent_type() {
    }
}
