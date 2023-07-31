package com.example.library.Service.Borrow;

import com.example.library.model.Book;
import com.example.library.model.People;

public interface IBorrowSerivce {
    boolean borrow (Book book, People people);
    boolean dueback(String code);
}
