package com.example.e1_form_validation.Dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;


@Getter
@Setter
@Component
public class UserDto implements Validator {
    private Long id;
    @Size(min = 5, max = 45, message = "First Name có độ dài từ 5 đến 45 kí tự !!")
    private String firstName;
    @Size(min = 5, max = 45, message = "Last Name Name có độ dài từ 5 đến 45 kí tự !!")
    private String lastName;
    private String phoneNumber;
    @Min(value = 18, message = "độ tuổi không được bé hơn 18 !!")
    private int age;
    @Email(message = "email không hợp le !!")
    private String email;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if (userDto.getFirstName().equals("")) {
            errors.rejectValue("firstName", null, "First Name không được bỏ trống !!!");
        }

        if (userDto.getLastName().equals("")) {
            errors.rejectValue("lastName", null, "Last Name không được bỏ trống !!!");
        }
        if (userDto.getPhoneNumber().matches("/0\\d{9}/")) {
            errors.rejectValue("phoneNumber", null, "Số điện thoại sai định dạng !!");
        }
        if (userDto.getFirstName().matches("/^[a-zA-Z]+$/")) {
            errors.rejectValue("phoneNumber", null, "tên bắt buộc phải là kiểu chữ");
        }
        if (userDto.getLastName().matches("/^[a-zA-Z]+$/")) {
            errors.rejectValue("phoneNumber", null, "tên bắt buộc phải là kiểu chữ");
        }
    }
}
