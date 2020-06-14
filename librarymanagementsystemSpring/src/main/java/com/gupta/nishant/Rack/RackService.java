package com.gupta.nishant.Rack;

import com.gupta.nishant.Book.Book;
import com.gupta.nishant.Book.BookNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RackService {

//    TODO: move this to rack repository and modify relevant functions here
//    characterwise map of String to each rack
    Map<Character, List<Rack>> rackMap = new HashMap<Character, List<Rack>>();

//    Aggregation relationship between rack and books since book can exist independently of a rack

    /**
     * Fetches a book if exists in the rack
     * @param Book to find in the rack
     * @return Rack where book is found
     * @throws BookNotFoundException if bok is not found in the racks
     */
    public Rack findBook(Book book) throws BookNotFoundException{
        char bookNameFirstLetter = book.getName().charAt(0);
        if(rackMap.get(bookNameFirstLetter) != null){
            Iterator<Rack> rackIterator = rackMap.get(bookNameFirstLetter).iterator();
            while(rackIterator.hasNext()) {
                Rack eachRack = rackIterator.next();
                if (eachRack.ifBookInRack(book)) {
                    return eachRack;
                }
            }
        }
        throw new BookNotFoundException("Book not found in any of the racks.");
    }


    /**
     * Adds a book to a rack and returns the rack identifier to which the book is added
     * APPROACH -   Get the first letter from the name of the book
     *              Create a rack with default capacity and add book to it
     *              If rack already exists then add the book to the rack
     *              If rack has already reached its capacity then create another rack for the same letter
     */
    public Rack addBookToRack(Book book){
//        TODO: add validation for book.name should not be null
        char bookNameFirstLetter = book.getName().charAt(0);
//        If it is the first book to be added to the rack, then create the rack to add the book to
        Rack rackToAddBook;
        if(rackMap.get(bookNameFirstLetter) == null){
            Rack newRack = new Rack(bookNameFirstLetter);
            List<Rack> newRackList = new ArrayList<>();
            newRackList.add(newRack);
            rackMap.put(bookNameFirstLetter, newRackList);
            rackToAddBook = newRack;
        }else{
//            Fetch the empty rack ( last rack from map ) from the book's first letter
            List<Rack> rackList = rackMap.get(bookNameFirstLetter);
            rackToAddBook = rackList.get(rackList.size());
        }
//        Add book to the rack
        try{
            boolean bookAddedToRack = rackToAddBook.addBook(book);
            return rackToAddBook;
        } catch(RackFullException rackFullException){
//                If rack is full then create anoter rack for the same letter and add the book to it.
            Rack newRackForExpansion = new Rack(bookNameFirstLetter);
            try {
                newRackForExpansion.addBook(book);
            } catch(RackFullException ex){
//                Nothing to do here since this is dead code and will never come here until rack capacity <= 0
            }
            rackMap.get(bookNameFirstLetter).add(newRackForExpansion);
            return newRackForExpansion;
        }

    }


    public void removeBook(Book book) throws BookNotFoundException{
        char bookNameFirstLetter = book.getName().charAt(0);
        boolean bookFound = false;
        if(rackMap.get(bookNameFirstLetter) != null){
            Iterator<Rack> rackIterator = rackMap.get(bookNameFirstLetter).iterator();
            while(rackIterator.hasNext()) {
                Rack eachRack = rackIterator.next();
                if (eachRack.ifBookInRack(book)) {
                    bookFound = true;
                    eachRack.removeBook(book);
                }
            }
        }

//        If book is not found in any of the racks then throw error that book is not found
        if(bookFound == false){
            throw new BookNotFoundException("Book not found in any of the racks.");
        }

    }

}
