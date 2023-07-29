package com.example.e1_form_validation.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fisrt_name",columnDefinition = "varchar(50)")
    private String firstName;
    @Column(name = "last_name",columnDefinition = "varchar(50)")
    private String lastName;
    private String phoneNumber;
    private int age;

    private String email;

    public User() {
    }

    public User(Long id, String firstName, String lastName, String phoneNumber, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }
}
