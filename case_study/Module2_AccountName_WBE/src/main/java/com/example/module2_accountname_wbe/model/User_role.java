package com.example.module2_accountname_wbe.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Getter
@Setter
public class User_role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user_role;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    @ManyToOne
    @JoinColumn(name = "user_name")
    @Column(columnDefinition = "varchar(255)")
    private User user;

    public User_role() {
    }
}
