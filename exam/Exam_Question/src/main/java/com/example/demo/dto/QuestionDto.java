package com.example.demo.dto;

import com.example.demo.model.Type;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Component
@Validated
public class QuestionDto implements Validator {

    private Long id;
    @NotBlank(message = "tiêu đề không được để trống !!")
    @Size(min = 5,max = 100,message = "tiêu đề từ 5-100 kí tự")
    private String title;
    @NotBlank(message = "nội dung không được để trống !!")
    @Size(min = 5,max = 100,message = "nội dung từ 10-500 kí tự")
    private String content;
    @NotBlank(message = "câu trả lời không được để trống !!")
    private String answer;
//    @NotBlank(message = "ngày tạo không được để trống !!")
    private String date_created;
    @NotBlank(message = "trạng thái không được để trống !!")
    private String status;
    private Type type;

    public QuestionDto() {
    }

    public QuestionDto(Long id, String title, String content, String answer, String date_created, String status, Type type) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.answer = answer;
        this.date_created = date_created;
        this.status = status;
        this.type = type;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
