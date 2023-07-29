package com.example.picture.service.comment;

import com.example.picture.model.comment;
import com.example.picture.repo.ICommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CommentService implements ICommentService{
    final
    ICommentRepo iCommentRepo;

    public CommentService(ICommentRepo iCommentRepo) {
        this.iCommentRepo = iCommentRepo;
    }

    @Override
    public Page<comment> findAll(Pageable pageable) {
        return iCommentRepo.findAll(pageable);
    }

    @Override
    public Page<comment> searchName(Pageable pageable, String searchName) {
        return null;
    }

    @Override
    public comment findById(Integer id) {
        return iCommentRepo.findById(id).orElse(null);
    }

    @Override
    public void save(comment comment) {
        iCommentRepo.save(comment);
    }

    @Override
    public void delete(Integer id) {
        iCommentRepo.deleteById(id);
    }
}
