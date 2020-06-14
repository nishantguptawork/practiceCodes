package com.gupta.nishant.Library;

import com.gupta.nishant.Book.Book;
import com.gupta.nishant.Book.BookNotAllotedException;
import com.gupta.nishant.Book.BookNotFoundException;
import com.gupta.nishant.Rack.Rack;

import java.util.UUID;

public interface LibraryInterface {
    Rack findBook(UUID uuid) throws BookNotFoundException;
    Book addBook(Book book);
    boolean allotBook(UUID uuid, int allotmentDurationDays);
    long returnBook(UUID uuid) throws BookNotAllotedException, BookNotFoundException;
}
