package com.example.e2_informationn_music.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Validation;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@Component
public class MusicDto implements Validator {

    private Long id;
    @Size(max = 800, message = "tên bài hát không quá 800 kí tự")
    @NotBlank(message = "tên không được để trống!!")
    @Pattern(regexp = ".*[@;,.=+\\-].*",message = "tên bài hát không đúng định dạng!!")
    private String name_Music;
    @Size(max = 300, message = "tên nhạc sĩ không quá 300 kí tự")
    @NotBlank(message = "tên không được để trống!!")
    @Pattern(regexp = ".*[@;,.=+\\-].*",message = "tên ca sĩ không đúng định dạng!!")
    private String musican;
    @Size(max = 300, message = "tên thể loại không được quá 1000 kí tự")
    @NotBlank(message = "tên không được để trống!!")
    @Pattern(regexp = ".*[^,a-zA-Z0-9].*",message = "tên thể loại không đúng định dạng!!")
    private String type;

    public MusicDto() {
    }

    public MusicDto(Long id, String name_Music, String musican, String type) {
        this.id = id;
        this.name_Music = name_Music;
        this.musican = musican;
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