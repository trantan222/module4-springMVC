package com.example.e1_picture_in_day.service.comment;

import com.example.e1_picture_in_day.model.comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICommentService {
    Page<comment> findAll(Pageable pageable);
    Page<comment> searchName(Pageable pageable,String searchName);
    comment findById(Integer id);
    void save(comment comment);
    void delete(Integer id);
}
