package com.example.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class QuestionContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tieu_de",columnDefinition = "varchar(100)")
    private String title;
    @Column(name = "noi_dung",columnDefinition = "varchar(100)")
    private String content;
    @Column(name = "phan_hoi",columnDefinition = "varchar(100)")
    private String answer;
    @Column(name = "ngay_tao",columnDefinition = "date")
    private LocalDate dateCreated;
    @Column(name = "trang_thai",columnDefinition = "bit")
    private int status;
    @ManyToOne
    @JoinColumn(name = "id_type")
    private Type type;

    public QuestionContent() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
