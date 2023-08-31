package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double price;
    private String date;
    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private category category;


    public product() {
    }


}
