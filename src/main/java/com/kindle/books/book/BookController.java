package com.kindle.books.book;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;  
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("")
    List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }
 
    @GetMapping("/{id}")
    Book findById(@PathVariable Integer id) {
        Optional<Book> book =  bookRepository.findById(id);
        if (book.isEmpty()) {
            throw new BookNotFoundException(id);
        }
        return book.get();
    }

    //post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void createBook(@Valid @RequestBody Book book){
        bookRepository.createBook(book);
    }

    //put
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void updateBook(@Valid @RequestBody Book book, @PathVariable Integer id) {
        bookRepository.updateBook(book,id);
    }


    //delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deleteBook(@PathVariable Integer id) {
        bookRepository.deleteBook(id);
    }

}
