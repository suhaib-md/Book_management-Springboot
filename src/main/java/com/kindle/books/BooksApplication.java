package com.kindle.books;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kindle.books.book.Book;
import com.kindle.books.book.BookRepository;
import com.kindle.books.book.Status;


@SpringBootApplication
public class BooksApplication {

	private static final Logger log = LoggerFactory.getLogger(BooksApplication.class);


	public static void main(String[] args) {

		
		SpringApplication.run(BooksApplication.class, args);

	}



}
