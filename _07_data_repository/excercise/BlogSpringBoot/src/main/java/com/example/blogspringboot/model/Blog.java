package com.example.blogspringboot.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    private String author;
    private String email;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "id_category",referencedColumnName = "id")
    private category category;

}
