package com.example.e2_picture_inn_day.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "url",columnDefinition = "int")
    private int vote;
    @Column(name = "author",columnDefinition = "varchar(50)")
    private String author;
    @Column(name = "feedback",columnDefinition = "varchar(50)")

    private String feedback;

    //@Column(name="value", nullable = false, columnDefinition="INT NOT NULL DEFAULT 1")
    @Column(name="liked", nullable = false)
    private int liked = 0;

    @ManyToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "picture_id")
    private Picture picture;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
