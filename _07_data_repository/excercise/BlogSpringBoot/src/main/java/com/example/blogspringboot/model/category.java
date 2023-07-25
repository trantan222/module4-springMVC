package com.example.blogspringboot.model;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Getter
@Setter
public class category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<Blog> blogList;

}
