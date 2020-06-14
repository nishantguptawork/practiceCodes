package com.gupta.nishant.Book;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class BookRepository{
    private Map<UUID, Book> allBookObjects = new HashMap<>();

    public boolean allotBook(UUID uuid, int allotmentDurationDays){
//        Mark the book status as alloted on current date for allotmentDurationDays days
        Book book = this.findBookByUUID(uuid);
        book.setAvailabilityStatus(BookAvailabilityEnum.AvailabilityStatus.ALLOTED);
        book.setAllotmentDate(new Date());
        book.setAllotmentDurationDays(allotmentDurationDays);
//        Below is used to persist to the actual data structure
        this.addBook(book);
        return true;
    }

    public void returnBook(Book book){
        book.setAvailabilityStatus(BookAvailabilityEnum.AvailabilityStatus.AVAILABLE);
        book.setAllotmentDate(null);
        book.setAllotmentDurationDays(0);
        //        Below is used to persist to the actual data structure
        this.addBook(book);
    }

    public Book findBookByUUID(UUID uuid){
        return allBookObjects.get(uuid);
    }

    public Book addBook(Book book){
        return allBookObjects.put(book.getUuid(), book);
    }





//    Below code is used in book controller
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

}
