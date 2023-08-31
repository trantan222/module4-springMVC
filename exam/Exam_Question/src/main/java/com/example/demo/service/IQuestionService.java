package com.example.demo.service;

import com.example.demo.dto.QuestionDto;
import com.example.demo.model.QuestionContent;
import com.example.demo.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IQuestionService {
    List<QuestionContent> findALl();
    Page<QuestionContent> findAllBYTitle(Pageable pageable, String name);
    Page<QuestionContent> findAllBy(Pageable pageable);
    void save(QuestionContent questionContent);
    QuestionContent findByid(Long id);
    void delete(Long id);
    Page<QuestionContent> findAllByTitleContainingAndType_Name(Pageable pageable, String title, String type);
    Page<QuestionContent> findAllByType_Name(Pageable pageable, String type);
}
