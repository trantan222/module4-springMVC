package com.example.demo.service;

import com.example.demo.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IQuestionService {
    List<QuestionContent> findALl();
    Page<QuestionContent> findAllBYTitle(Pageable pageable, String name);
    Page<QuestionContent> findAllBy(Pageable pageable);
}
