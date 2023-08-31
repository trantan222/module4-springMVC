package com.example.demo.service;

import com.example.demo.model.QuestionContent;
import com.example.demo.model.Type;
import com.example.demo.repository.IQuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionService implements IQuestionService{
    final
    IQuestionRepo iQuestionRepo;

    public QuestionService(IQuestionRepo iQuestionRepo) {
        this.iQuestionRepo = iQuestionRepo;
    }

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

    @Override
    public void save(QuestionContent questionContent) {
        iQuestionRepo.save(questionContent);
    }

    @Override
    public QuestionContent findByid(Long id) {
        return iQuestionRepo.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        iQuestionRepo.deleteById(id);
    }

    @Override
    public Page<QuestionContent> findAllByTitleContainingAndType_Name(Pageable pageable, String title, String type) {
        return iQuestionRepo.findByTitleContainingAndType_Name(pageable, title, type);
    }

    @Override
    public Page<QuestionContent> findAllByType_Name(Pageable pageable, String type) {
        return iQuestionRepo.findAllByType_Name(pageable, type);
    }


}
