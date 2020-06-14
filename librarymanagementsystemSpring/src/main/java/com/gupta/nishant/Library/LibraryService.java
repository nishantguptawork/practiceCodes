package com.gupta.nishant.Library;

import com.gupta.nishant.Book.Book;
import com.gupta.nishant.Book.BookNotAllotedException;
import com.gupta.nishant.Book.BookNotFoundException;
import com.gupta.nishant.Book.BookService;
import com.gupta.nishant.Rack.Rack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryService implements LibraryInteface{

    @Autowired
    public BookService bookService;

    /**
     * IDEAS - Composition from library to racks since racks cannot exist independently without the parent
     *         Aggregation between racks and books since books can exist independently of racks
     *         define all interfaces along with implementation
     *         single repository of all books. Then operation to search book in which rack
     *         person base class with ( borrower, librarian, etc )
    */

    @Override
    public Rack findBook(Book book) throws BookNotFoundException {
        return bookService.findBook(book);
    }

    @Override
    public Rack addBook(Book book) {
        return bookService.addBook(book);
    }

    @Override
    public boolean allotBook(Book book, int allotmentDurationDays) {
        return bookService.allotBook(book, allotmentDurationDays);
    }

    @Override
    public long returnBook(Book book) throws BookNotAllotedException,BookNotFoundException {
        return bookService.returnBook(book);
    }

}
