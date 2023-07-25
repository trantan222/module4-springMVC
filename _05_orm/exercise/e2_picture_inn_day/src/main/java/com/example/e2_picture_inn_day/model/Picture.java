package com.example.e2_picture_inn_day.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
@Column(name = "name",columnDefinition = "varchar(50)")
    private String name;
    @Column(name = "url",columnDefinition = "varchar(50)")
    private String url;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date",columnDefinition = "date")

    private LocalDate displayDate;

    @OneToMany(mappedBy = "picture", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDate getDisplayDate() {
        return displayDate;
    }

    public void setDisplayDate(LocalDate displayDate) {
        this.displayDate = displayDate;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
