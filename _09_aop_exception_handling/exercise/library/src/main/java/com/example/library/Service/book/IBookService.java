package com.example.library.Service.book;

import com.example.library.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> findAll(Pageable pageable);
    boolean create(Book book);
    void delete(Integer id);
    Book findById(Integer id);

}
