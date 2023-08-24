package com.example.module2_accountname_wbe.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long service_id;
    @Column(columnDefinition = "varchar(45)")
    private String service_name;
    private Long service_Area;
    private double service_Cost;
    private Long service_max_people;

    @ManyToOne
    @JoinColumn(name = "rent_type_id",referencedColumnName = "rent_type_id")
    private Rent_type rent_type;

    @ManyToOne
    @JoinColumn(name = "Service_type_id",referencedColumnName = "Service_type_id")
    private Service_type service_type;

    @Column(columnDefinition = "varchar(45)")
    private String standard_room;
    @Column(columnDefinition = "varchar(45)")
    private String description_other_convicence;
    private double pool_area;
    private int number_of_floor;

    public Service() {
    }

}
