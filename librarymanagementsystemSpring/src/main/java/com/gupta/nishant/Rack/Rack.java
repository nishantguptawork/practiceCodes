package com.gupta.nishant.Rack;


import com.gupta.nishant.Book.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Rack {

//    Aggregation between rack and books - Reference https://www.baeldung.com/java-composition-aggregation-association
    private List<Book> books;
//    Identity of each rack to be generated as a unique key for each rack.
    private int identity;
    private int capacity;
    private char letter;
    private UUID uuid;

    //    static counter to give identity to each new rack created.
    private static int rackCount = 0;

//    Constructor to create a rack with default capacity
    public Rack(char letter) {
        this.letter = letter;
        this.capacity = Constants.capacity;
        this.books = new ArrayList<>();
        this.identity = rackCount++;
        this.uuid = UUID.randomUUID();
    }

//    Overloaded constructor
//    Constructor to create a rack with a defined capacity
    public Rack(int capacity, char letter) {
        this.capacity = capacity;
        this.letter = letter;
        this.books = new ArrayList<>();
        this.identity = rackCount++;
        this.uuid = UUID.randomUUID();
    }

    public int getIdentity() {
        return identity;
    }

//    Commenting the setter for rack identity since we want it to be immutable
//    public void setIdentity(int identity) {
//        this.identity = identity;
//    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }


    /**
     *     Adds book to a rack. Throws RackFullException when rack has reached its capacity and no books can be added further
     * @param book
     * @return true if book is succesfully added to the rack, false otherwise ( even when there is an exception adding the book to the list )
     * @throws RackFullException if the rack has reached its maximum capacity
     */
    public boolean addBook(Book book) throws RackFullException{
        if(books.size() == this.capacity){
            throw new RackFullException("Rack has reached its maximum capacity.");
        }else{
//            Handle the exceptions thrown by list.add method gracefully.
            try{
                return books.add(book);
            } catch(Exception ex){
                return false;
            }

        }
    }

    public boolean ifBookInRack(Book book){
        return books.contains(book);
    }

    public void removeBook(Book book){
        books.remove(book);
    }

}
