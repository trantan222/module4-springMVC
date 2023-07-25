package com.example.blog1.model;
import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String content_blog;

    public Blog() {
    }

    public Blog(Long id, String author, String content_blog) {
        this.id = id;
        this.author = author;
        this.content_blog = content_blog;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent_blog() {
        return content_blog;
    }

    public void setContent_blog(String content_blog) {
        this.content_blog = content_blog;
    }
}
