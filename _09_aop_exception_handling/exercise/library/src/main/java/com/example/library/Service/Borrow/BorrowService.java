package com.example.library.Service.Borrow;

import com.example.library.Repository.IBookRepo;
import com.example.library.Repository.IBorrowRepo;
import com.example.library.Repository.IPeopleRepo;
import com.example.library.Service.book.IBookService;
import com.example.library.Service.people.IPeopleService;
import com.example.library.exception.BookBorrowException;
import com.example.library.model.Book;
import com.example.library.model.Borrow;
import com.example.library.model.People;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import java.util.Random;

public class BorrowService implements IBorrowSerivce{
    @Autowired
    IBookService iBookService;
    @Autowired
    IBorrowRepo iBorrowRepo;
    @Autowired
    IPeopleService iPeopleService;
    @Override
    public boolean borrow(Book book, People people) {
        if(book.getQuanity() == 0){
            throw new BookBorrowException("Quantity book less than 0");
        }
        try{
            People NewPeople = iPeopleService.create(people);
            book.setQuanity(book.getQuanity()-1);
            iBookService.create(book);
            Borrow borrow = new Borrow();
            borrow.setCode(RandomString.);
        }catch (DataAccessException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean dueback(String code) {
        return false;
    }
}
