package com.example.demo.model;

import javax.persistence.*;

@Entity
public class QuestionContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String answer;
    private String date_created;
    private String status;
    @ManyToOne
    @JoinColumn(name = "id_question_type",referencedColumnName = "id")
    private Type type;



}
