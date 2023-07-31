package com.example.library.exception;

public class BookBorrowException extends RuntimeException{
    public BookBorrowException(String message) {
        super(message);
    }
}
