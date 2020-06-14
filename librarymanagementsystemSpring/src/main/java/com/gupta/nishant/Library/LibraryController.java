package com.gupta.nishant.Library;

import com.gupta.nishant.Book.Book;
import com.gupta.nishant.Book.BookNotAllotedException;
import com.gupta.nishant.Book.BookNotFoundException;
import com.gupta.nishant.RESTEntitites.FailureResponseEntity;
import com.gupta.nishant.RESTEntitites.ResponseBaseEntity;
import com.gupta.nishant.RESTEntitites.SuccessfulResponseEntity;
import com.gupta.nishant.Rack.Rack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class LibraryController {

    @Autowired
    public LibraryService libraryService;

//    Controller level exception handler
//    @ExceptionHandler({BookNotFoundException.class, BookNotAllotedException.class})
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public void handleException(){
//
//    }

    //    Consumes - specify that the API will accept only passed media types
//    produces - specify that the API will generate what kind of media type in the response
    @RequestMapping(value="/library/book", method=RequestMethod.GET, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<ResponseBaseEntity> findBook(@RequestParam UUID uuid){
        ResponseBaseEntity response;
        try{
            Rack bookFoundInRack = libraryService.findBook(uuid);
            response = new SuccessfulResponseEntity("Book found in rack.", bookFoundInRack );
        } catch(BookNotFoundException ex){
            response = new FailureResponseEntity("Book not found." , ex.getMessage());
        }
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(value="/library/book", method=RequestMethod.POST,  consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<ResponseBaseEntity> addBook(@RequestBody Book book){
        SuccessfulResponseEntity response = new SuccessfulResponseEntity("Added book successfully to the library.",libraryService.addBook(book));
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(value="/library/book/allotment", method=RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<Boolean> allotBook(@RequestParam UUID uuid, @RequestParam int allotmentDurationDays){
        return ResponseEntity.ok(libraryService.allotBook(uuid,allotmentDurationDays));
    }

    @RequestMapping(value="/library/book/allotment", method=RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<Long> returnBook(@RequestParam UUID uuid) throws BookNotFoundException, BookNotAllotedException {
        return ResponseEntity.ok(libraryService.returnBook(uuid));
    }

}
