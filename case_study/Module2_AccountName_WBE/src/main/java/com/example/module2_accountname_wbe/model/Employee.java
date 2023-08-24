package com.example.module2_accountname_wbe.model;

import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(45)")
    private String name;

    private LocalDate date;

    @Column(columnDefinition = "varchar(45)")
    private String id_card;

    private double salary;

    @Column(columnDefinition = "varchar(45)")
    private String phone;

    @Column(columnDefinition = "varchar(45)")
    private String email;

    @Column(columnDefinition = "varchar(45)")
    private String address;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;
    @ManyToOne
    @JoinColumn(name = "education_degree_id", referencedColumnName = "id")
    private Education_degree education_degree;
    @ManyToOne
    @JoinColumn(name = "division_id", referencedColumnName = "id")
    private Division division;

    public Employee() {
    }

    @OneToOne
    @JoinColumn(name = "user_name")
    private User username;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getDate() {
        return date;
    }

    public String getId_card() {
        return id_card;
    }

    public double getSalary() {
        return salary;
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

    public Education_degree getEducation_degree() {
        return education_degree;
    }

    public Division getDivision() {
        return division;
    }

    public User getUsername() {
        return username;
    }

    public Position getPosition() {
        return position;
    }
}
