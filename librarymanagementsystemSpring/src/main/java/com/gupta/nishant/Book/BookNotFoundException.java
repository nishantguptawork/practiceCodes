package com.gupta.nishant.Book;

public class BookNotFoundException extends Exception{
    public BookNotFoundException(){

    }

    public BookNotFoundException(String message){
        super(message);
    }
}
