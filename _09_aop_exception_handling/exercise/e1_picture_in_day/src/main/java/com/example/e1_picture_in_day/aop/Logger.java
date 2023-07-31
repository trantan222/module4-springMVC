package com.example.e1_picture_in_day.aop;

import com.example.e1_picture_in_day.Dto.commentDto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
public class Logger {
    private static int count = 0;

    @After("execution( * com.example.e1_picture_in_day.controller.CommentController.*(..))")
    public void count() {
        count++;
        System.out.println("số lần truy cập " + count);
    }

    @After("execution( * com.example.e1_picture_in_day.controller.CommentController.save(..))")
    public Object BadFeedback(JoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        commentDto commentDto = (com.example.e1_picture_in_day.Dto.commentDto) args[0];
        System.out.println("Tên tác giả  : " + commentDto.getAuthor());
        System.out.println("vote  : " + commentDto.getVote());
        System.out.println("nội dung feedback : " + commentDto.getFeedback());
        System.out.println("thời gian : " + LocalDateTime.now());

////        StudentDto studentDto = (StudentDto) args[0];
////        // ghi vào file
////        System.out.println("Tên người mới thêm : " + studentDto.getName());
//
//        Object o = joinPoint.proceed();
        return commentDto;
    }
}
