package com.example.library.Service.book;

import com.example.library.Repository.IBookRepo;
import com.example.library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {
    final
    IBookRepo iBookRepo;

    public BookService(IBookRepo iBookRepo) {
        this.iBookRepo = iBookRepo;
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return iBookRepo.findAll(pageable);
    }

    @Override
    public boolean create(Book book) {
        iBookRepo.save(book);
        return true;
    }

    @Override
    public void delete(Integer id) {
        iBookRepo.deleteById(id);
    }

    @Override
    public Book findById(Integer id) {
        return iBookRepo.findById(id).orElse(null);
    }
}
