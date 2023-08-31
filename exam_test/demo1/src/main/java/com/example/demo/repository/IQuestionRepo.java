package com.example.demo.repository;

import com.example.demo.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuestionRepo extends JpaRepository<QuestionContent,Long> {
    Page<QuestionContent> findAllByTitleContaining(Pageable pageable,String title);
    Page<QuestionContent> findAllBy(Pageable pageable);
}
