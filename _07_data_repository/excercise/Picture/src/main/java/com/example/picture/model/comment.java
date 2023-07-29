package com.example.picture.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
@Entity
public class comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "vote",columnDefinition = "int")
    private int vote;
    @Column(name = "author",columnDefinition = "varchar(50)")
    private String author;
    @Column(name = "feedback",columnDefinition = "varchar(50)")

    private String feedback;

    //@Column(name="value", nullable = false, columnDefinition="INT NOT NULL DEFAULT 1")
    @Column(name="liked", nullable = false)
    private int liked = 0;


    public comment(Integer id, int vote, String author, String feedback, int liked) {
        this.id = id;
        this.vote = vote;
        this.author = author;
        this.feedback = feedback;
        this.liked = liked;
    }

    public comment() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getLiked() {
        return liked;
    }

    public void setLiked(int liked) {
        this.liked = liked;
    }
}
