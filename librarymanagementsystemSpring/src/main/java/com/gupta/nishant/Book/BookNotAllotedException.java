package com.gupta.nishant.Book;

public class BookNotAllotedException extends Exception {
    BookNotAllotedException(String message){
        super(message);
    }
}
