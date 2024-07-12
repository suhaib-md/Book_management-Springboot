package com.kindle.books.book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class BookRepository {

    private List<Book> books = new ArrayList<>();

    List<Book> getAllBooks() {
        return books;
    }

    Optional<Book> findById(Integer id) {
        return books.stream().filter(book -> book.id().equals(id)).findFirst();
    }

    @PostConstruct
    private void init() {
        books.add(new Book(1,"The Lost Symbol", "Dan Brown", "978-0-552-16123-7", "Corgi", "2009", "Robert Langdon Mystery", "image_url", Status.READING));
        books.add(new Book(2, "To Kill a Mockingbird", "Harper Lee", "978-0-06-112008-4", "J.B. Lippincott & Co.", "1960", "Classic novel of racism and injustice", "image_url", Status.COMPLETED));
        books.add(new Book(3, "1984", "George Orwell", "978-0-452-28423-4", "Secker & Warburg", "1949", "Dystopian social science fiction", "image_url", Status.WANT_TO_READ));
        books.add(new Book(4, "The Great Gatsby", "F. Scott Fitzgerald", "978-0-7432-7356-5", "Charles Scribner's Sons", "1925", "Novel about the American Dream", "image_url", Status.READING));
    }


}
