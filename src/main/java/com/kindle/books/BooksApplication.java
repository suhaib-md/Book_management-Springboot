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
/* 
	@Bean
	CommandLineRunner runner(BookRepository bookRepository) {
		return args -> {
			Book book = new Book(1,"The Lost Symbol", "Dan Brown", "978-0-552-16123-7", "Corgi", "2009", "Robert Langdon Mystery book", "image_url",Status.COMPLETED);
			bookRepository.createBook(book);
		};
	}
*/



}
