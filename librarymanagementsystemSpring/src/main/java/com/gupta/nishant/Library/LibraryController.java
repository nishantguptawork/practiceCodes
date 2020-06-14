package com.gupta.nishant.Library;

import com.gupta.nishant.Book.Book;
import com.gupta.nishant.Book.BookNotAllotedException;
import com.gupta.nishant.Book.BookNotFoundException;
import com.gupta.nishant.Rack.Rack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LibraryController {

    @Autowired
    public LibraryService libraryService;

//    Controller level exception handler
    @ExceptionHandler({BookNotFoundException.class, BookNotAllotedException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleException(){

    }

    //    Consumes - specify that the API will accept only passed media types
//    produces - specify that the API will generate what kind of media type in the response
    @RequestMapping(value="/library/book", method=RequestMethod.GET, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<Rack> findBook(@RequestBody Book book) throws BookNotFoundException {
        return ResponseEntity.ok(libraryService.findBook(book));
    }

    @RequestMapping(value="/library/book", method=RequestMethod.POST,  consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<Rack> addBook( @RequestBody Book book){
        return ResponseEntity.ok(libraryService.addBook(book));
    }

    @RequestMapping(value="/library/book/allotment", method=RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<Boolean> allotBook(@RequestBody Book book, @RequestParam int allotmentDurationDays){
        return ResponseEntity.ok(libraryService.allotBook(book,allotmentDurationDays));
    }

    @RequestMapping(value="/library/book/allotment", method=RequestMethod.DELETE, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<Long> returnBook(@RequestBody Book book) throws BookNotFoundException, BookNotAllotedException {
        return ResponseEntity.ok(libraryService.returnBook(book));
    }

}
