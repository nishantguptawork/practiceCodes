package com.gupta.nishant.Book;

import com.gupta.nishant.Rack.Rack;
import com.gupta.nishant.Rack.RackService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class Book {

    private String name;
    private String genre;
    private int cost;
    private int finePerDay;
    private BookAvailabilityEnum.AvailabilityStatus availabilityStatus;
    private Date allotementDate;
    private int allotmentDurationDays;

    @Autowired
    private RackService rackService;

    public Book(String name, String genre, int cost, int finePerDay) {
        this.name = name;
        this.genre = genre;
        this.cost = cost;
        this.finePerDay = finePerDay;
        this.availabilityStatus = BookAvailabilityEnum.AvailabilityStatus.AVAILABLE;
    }

    /**
     *         Allocates a rack to the book based on the name of the book ( racks to have books in alphabetical order )
     *         APPROACH -   Based on name get the rack number
     *                      Check and create rack if required with default capacity
     *                      If capacity is full then create another rack
     */
    public Rack allocateRack(Book book){
        return rackService.addBookToRack(book);
    }

    @Override
    public String toString(){
        return "(" + this.name + ", " + this.genre + ", " + this.cost + ")";
    }

    @Override
    public int hashCode() {
        return ( this.name + this.genre ).hashCode();
    }

    @Override
    public boolean equals(Object anotherBook){
        if(this==anotherBook)
            return true;
        if(!(anotherBook instanceof Book))
            return false;
        Book anotherBookCasted = (Book) anotherBook;
        boolean equalsCondition = anotherBookCasted.name.equalsIgnoreCase(this.getName()) && anotherBookCasted.getGenre().equalsIgnoreCase(this.genre) &&
                anotherBookCasted.getCost() == this.cost &&  anotherBookCasted.getFinePerDay() == this.finePerDay &&
                anotherBookCasted.getAvailabilityStatus() == this.availabilityStatus;
        return equalsCondition;
    }

    public int getFinePerDay() {
        return finePerDay;
    }

    public void setFinePerDay(int finePerDay) {
        this.finePerDay = finePerDay;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public int getCost() {
        return cost;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public BookAvailabilityEnum.AvailabilityStatus getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(BookAvailabilityEnum.AvailabilityStatus availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public Date getAllotementDate() {
        return allotementDate;
    }

    public void setAllotementDate(Date allotementDate) {
        this.allotementDate = allotementDate;
    }

    public int getAllotmentDurationDays() {
        return allotmentDurationDays;
    }

    public void setAllotmentDurationDays(int allotmentDurationDays) {
        this.allotmentDurationDays = allotmentDurationDays;
    }
}
