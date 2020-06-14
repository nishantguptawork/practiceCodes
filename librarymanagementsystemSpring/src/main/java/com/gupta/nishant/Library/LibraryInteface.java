package com.gupta.nishant.Library;

import com.gupta.nishant.Book.Book;
import com.gupta.nishant.Book.BookNotAllotedException;
import com.gupta.nishant.Book.BookNotFoundException;
import com.gupta.nishant.Rack.Rack;

public interface LibraryInteface {
    Rack findBook(Book book) throws BookNotFoundException;
    Rack addBook(Book book);
    boolean allotBook(Book book, int allotmentDurationDays);
    long returnBook(Book book) throws BookNotAllotedException, BookNotFoundException;
}
