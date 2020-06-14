package com.gupta.nishant.Book;

import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class BookRepository{

    private Map<Book, Integer> booksMap;

    public BookRepository(Map<Book, Integer> booksMap) {
        this.booksMap = booksMap;
    }

    public Book crateBook(Book book) {
        // If book is found in the map then increment the book count
        if(booksMap.containsKey(book)){
            booksMap.put(book,booksMap.get(book) + 1);
        }
        else{
            booksMap.put(book,1);
        }
        return book;
    }

    public List<Book> getAllbooks(){
        return booksMap.keySet().stream().collect(Collectors.toList());
    }

    public Book findBook(Book book) throws BookNotFoundException{
        if(!booksMap.containsKey(book)){
            throw new BookNotFoundException(book + " not found.");
        }
        else {
            int bookCountAfterFetch = booksMap.get(book) - 1;
//            If book count after removal of this book is 0 then remove that book from the map, else reduce the count of that book by 1
            if(bookCountAfterFetch == 0)
                booksMap.remove(book);
            else
                booksMap.put(book,bookCountAfterFetch);
            return book;
        }
    }

    public boolean allotBook(Book book, int allotmentDurationDays){
//        Mark the book status as alloted on current date for allotmentDurationDays days
        book.setAvailabilityStatus(BookAvailabilityEnum.AvailabilityStatus.ALLOTED);
        book.setAllotementDate(new Date());
        book.setAllotmentDurationDays(allotmentDurationDays);
        return true;
    }

    public void returnBook(Book book){
        book.setAvailabilityStatus(BookAvailabilityEnum.AvailabilityStatus.AVAILABLE);
        book.setAllotementDate(null);
        book.setAllotmentDurationDays(0);
    }

}
