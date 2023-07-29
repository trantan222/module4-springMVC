package com.example.picture.repo;

import com.example.picture.model.comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepo extends JpaRepository<comment,Integer> {

    Page<comment> findAllByAuthorContaining(Pageable pageable,String name);

}
