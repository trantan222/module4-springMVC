package com.example.e1_form_validation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
public class E1FormValidationApplication {

    public static void main(String[] args) {
        SpringApplication.run(E1FormValidationApplication.class, args);
    }
//    @Bean
//    public MessageSource messageSource() {
//        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//        messageSource.setBasenames("validation-message");
//        return messageSource;
//    }

}
