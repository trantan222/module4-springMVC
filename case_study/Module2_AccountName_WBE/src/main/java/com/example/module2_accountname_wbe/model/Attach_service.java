package com.example.module2_accountname_wbe.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Attach_service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attach_service_id;
    @Column(columnDefinition = "varchar(45)")
    private String attach_service_name;
    private double attach_service_cost;
    private int attach_service_unit;
    @Column(columnDefinition = "varchar(45)")
    private String attach_service_status;

    public Attach_service() {
    }
}
