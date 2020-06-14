package com.gupta.nishant.Book;

import com.gupta.nishant.Rack.Rack;

import java.util.UUID;

public interface BookInterface {
//    Marks book as lost or damaged and not fit for reuse again ever.
    boolean markAsLostOrDamaged(int bookIdentity);
//    Computes fine based on book's fine per day for fineForDays number of days
    long computeFine(Book book) throws BookNotAllotedException;
    Rack findBook(UUID uuid) throws BookNotFoundException;
    Book addBook(Book book);
    boolean allotBook(UUID uuid, int allotmentDurationDays);
    long returnBook(UUID uuid) throws BookNotAllotedException,BookNotFoundException;
}
