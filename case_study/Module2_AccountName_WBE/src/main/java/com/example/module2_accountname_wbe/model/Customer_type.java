package com.example.module2_accountname_wbe.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Customer_type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customer_type_id;
    @Column(columnDefinition = "varchar(45)")
    private String customer_type_name;

    @OneToMany(mappedBy = "Customer_type",cascade = CascadeType.ALL)
    private List<Customer> customers;

    public Customer_type() {
    }
}
