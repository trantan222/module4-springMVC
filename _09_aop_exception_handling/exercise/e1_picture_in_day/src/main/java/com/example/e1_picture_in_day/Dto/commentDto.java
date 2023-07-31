package com.example.e1_picture_in_day.Dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;

public class commentDto implements Validator {
    private Integer id;
    private int vote;
    private String author;

    private String feedback;
    private int liked = 0;


    public commentDto(Integer id, int vote, String author, String feedback, int liked) {
        this.id = id;
        this.vote = vote;
        this.author = author;
        this.feedback = feedback;
        this.liked = liked;
    }

    public commentDto() {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        commentDto commentDto = (com.example.e1_picture_in_day.Dto.commentDto) target;
        String arr[] = {"xấu","rất xấu","hate"};
        for (int i = 0; i <arr.length ; i++) {
            if(commentDto.getFeedback().toLowerCase().equals(arr[i])){
                errors.rejectValue("feedback",null,"feedback có từ ngữ xấu");
            }
        }
    }
}
