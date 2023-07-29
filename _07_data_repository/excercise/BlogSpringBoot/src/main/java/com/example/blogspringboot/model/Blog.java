package com.example.blogspringboot.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    private String author;
    private String email;

    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "id_category",referencedColumnName = "id")
    private category category;

    public Blog() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDate() {
        return date;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public com.example.blogspringboot.model.category getCategory() {
        return category;
    }

    public void setCategory(com.example.blogspringboot.model.category category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
