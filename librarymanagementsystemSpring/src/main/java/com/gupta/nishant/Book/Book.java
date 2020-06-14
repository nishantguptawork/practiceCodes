package com.gupta.nishant.Book;

import java.util.Date;
import java.util.UUID;

public class Book {

    private UUID uuid;
    private String name;
    private String genre;
    private int cost;
    private int finePerDay;
    private BookAvailabilityEnum.AvailabilityStatus availabilityStatus;
    private Date allotmentDate;
    private int allotmentDurationDays;

    public Book(String name, String genre, int cost, int finePerDay, BookAvailabilityEnum.AvailabilityStatus availableStatus, UUID uuid) {
        this.name = name;
        this.genre = genre;
        this.cost = cost;
        this.finePerDay = finePerDay;
//        By default while adding the book to library it should be available
        this.availabilityStatus = (availableStatus!=null) ? availableStatus: BookAvailabilityEnum.AvailabilityStatus.AVAILABLE;
        this.uuid = uuid!=null ? uuid : UUID.randomUUID();
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

    public int getAllotmentDurationDays() {
        return allotmentDurationDays;
    }

    public void setAllotmentDurationDays(int allotmentDurationDays) {
        this.allotmentDurationDays = allotmentDurationDays;
    }

    public UUID getUuid() {
        return uuid;
    }

//    public void setUuid(UUID uuid) {
//        this.uuid = uuid;
//    }

    public Date getAllotmentDate() {
        return allotmentDate;
    }

    public void setAllotmentDate(Date allotmentDate) {
        this.allotmentDate = allotmentDate;
    }
}
