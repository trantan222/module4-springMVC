
package com.example.demo.repository;

import com.example.demo.model.QuestionContent;
import com.example.demo.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface IQuestionRepo extends JpaRepository<QuestionContent,Long> {
    Page<QuestionContent> findAllByTitleContaining(Pageable pageable,String title);
    Page<QuestionContent> findByTitleContainingAndType_NameContaining(Pageable pageable, String title, String type);
    Page<QuestionContent> findAllByType_Name(Pageable pageable, String type);
    Page<QuestionContent> findAllBy(Pageable pageable);
}
