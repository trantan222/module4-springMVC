package com.example.demo.service;

import com.example.demo.model.QuestionContent;
import com.example.demo.repository.IQuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionService implements IQuestionService{
    @Autowired
    IQuestionRepo iQuestionRepo;
    @Override
    public List<QuestionContent> findALl() {
        return iQuestionRepo.findAll();
    }

    @Override
    public Page<QuestionContent> findAllBYTitle(Pageable pageable, String name) {
        return iQuestionRepo.findAllByTitleContaining(pageable,name);
    }

    @Override
    public Page<QuestionContent> findAllBy(Pageable pageable) {
        return iQuestionRepo.findAllBy(pageable);
    }


}
