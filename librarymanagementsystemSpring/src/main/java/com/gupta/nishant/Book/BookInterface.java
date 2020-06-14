package com.gupta.nishant.Book;

import com.gupta.nishant.Rack.Rack;

public interface BookInterface {
//    Marks book as lost or damaged and not fit for reuse again ever.
    boolean markAsLostOrDamaged(int bookIdentity);
//    Computes fine based on book's fine per day for fineForDays number of days
    long computeFine(Book book) throws BookNotAllotedException;
    Rack findBook(Book book) throws BookNotFoundException;
    Rack addBook(Book book);
    boolean allotBook(Book book, int allotmentDurationDays);
    long returnBook(Book book) throws BookNotAllotedException,BookNotFoundException;
}
