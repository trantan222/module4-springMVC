package com.example.module2_accountname_wbe.model;

import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.BitSet;
import java.util.Date;

@Entity
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customer_id;

    @ManyToOne
    @JoinColumn(name = "customer_type_id")
    private Customer_type customer_type_id;

    private String customer_name;

    private Date customer_date;

    @Column(columnDefinition = "bit(1)")
    private Integer customer_gender;

    @Column(columnDefinition = "varchar(45)")
    private String id_card;

    @Column(columnDefinition = "varchar(45)")
    private String phone;

    @Column(columnDefinition = "varchar(45)")
    private String email;

    @Column(columnDefinition = "varchar(45)")
    private String address;

    public Customer() {
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public Customer_type getCustomer_type_id() {
        return customer_type_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date getCustomer_date() {
        return customer_date;
    }

    public Integer getCustomer_gender() {
        return customer_gender;
    }

    public String getId_card() {
        return id_card;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}
