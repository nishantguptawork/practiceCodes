package com.gupta.nishant.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    public BookRepository bookRepository;

//    Consumes - specify that the API will accept only passed media types
//    produces - specify that the API will generate what kind of media type in the response
    @RequestMapping(value="/books", method=RequestMethod.GET, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<List<Book>> findAllBooks(){
        return ResponseEntity.ok(bookRepository.getAllbooks());
    }

    @RequestMapping(value="/books", method=RequestMethod.POST,  consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<Book> createBook( @RequestBody Book book){
        return ResponseEntity.ok(bookRepository.crateBook(book));
    }

}
