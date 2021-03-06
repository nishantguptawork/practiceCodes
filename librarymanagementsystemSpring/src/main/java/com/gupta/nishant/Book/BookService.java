package com.gupta.nishant.Book;

import com.gupta.nishant.Rack.Rack;
import com.gupta.nishant.Rack.RackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;


@Service
public class BookService implements BookInterface{

    @Autowired
    RackService rackService;
    @Autowired
    BookRepository bookRepository;


    @Override
    public boolean markAsLostOrDamaged(int bookIdentity) {
        return false;
    }

    private int calculateDifferenceInDays(Date startDate, Date endDate){
        int diffInDays = (int) ((endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24));
        return diffInDays;
    }

    @Override
    public long computeFine(Book book) throws BookNotAllotedException{
        if(book.getAvailabilityStatus() != BookAvailabilityEnum.AvailabilityStatus.ALLOTED){
            throw new BookNotAllotedException("Book is not alloted, hence return book operation not allowed.");
        }
        else{
            Date allotmentDate = book.getAllotmentDate();
            Date today = new Date();
            int actualDurationDays = this.calculateDifferenceInDays(allotmentDate, today);
            int bookAllotmentDuration = book.getAllotmentDurationDays();
            if(actualDurationDays > bookAllotmentDuration){
                int fineForDays = actualDurationDays - bookAllotmentDuration;
                long totalFine = book.getFinePerDay() * fineForDays;
                return totalFine;
            }
            return 0L;
        }
    }

    @Override
    public Rack findBook(UUID uuid) throws BookNotFoundException {
        Book book = bookRepository.findBookByUUID(uuid);
        return rackService.findBook(book);
    }

    @Override
    public Book addBook(Book book) {
        bookRepository.addBook(book);
        return rackService.addBookToRack(book);
    }

    @Override
    public boolean allotBook(UUID uuid, int allotmentDurationDays) {
        return bookRepository.allotBook(uuid, allotmentDurationDays);
    }

    @Override
    public long returnBook(UUID uuid) throws BookNotAllotedException, BookNotFoundException{
        Book book = bookRepository.findBookByUUID(uuid);
//        Compute fine for the duration as per allotment
        long fineToBePaid = this.computeFine(book);
        // mark book availability status as AVAILABLE
        bookRepository.returnBook(book);
//        Remove the book from the rack
        rackService.removeBook(book);
        return fineToBePaid;
    }

/*@Autowired
    private BookRepository bookRepository;

    public List<Book> getAllbooks(){
        return bookRepository.getAllbooks();
    }

    public void crateBook(Book book){
//        Create a book
        Book createdBook = bookRepository.crateBook(book);
//        Add the book to a rack

    }

//    fetches the book if present else throws an error. Also keeps count of each book in the inventory
    public Book findBook(Book book) throws BookNotFoundException{
        return bookRepository.findBook(book);
    }*/

}
