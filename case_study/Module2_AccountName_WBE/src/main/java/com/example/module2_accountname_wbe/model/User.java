package com.example.module2_accountname_wbe.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class User {
    @Id
    @Column(columnDefinition = "varchar(255)")
    private String username;
    @Column(columnDefinition = "varchar(255)")
    private String password;

    public User() {
    }
}
