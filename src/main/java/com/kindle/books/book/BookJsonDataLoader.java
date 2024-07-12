package com.kindle.books.book;

import java.io.InputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aot.hint.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class BookJsonDataLoader implements CommandLineRunner{

    private static final Logger log = LoggerFactory.getLogger(BookJsonDataLoader.class);
    private final BookRepository bookRepository;
    private final ObjectMapper objectMapper;

    public BookJsonDataLoader(BookRepository bookRepository, ObjectMapper objectMapper) {
        this.bookRepository = bookRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        if (bookRepository.count() == 0) {
            try(InputStream inputStream = TypeReference.class.getResourceAsStream("/data/books.json")) {
                Books allBooks = objectMapper.readValue(inputStream, Books.class);
                log.info("Loading {} books", allBooks.books().size());
                bookRepository.saveAll(allBooks.books());
            } catch (IOException e) {
                log.error("Failed to load books", e);
            }
        } else {
            log.info("Collection already contains data");
        }
    }

}
