package com.kindle.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.kindle.books.config.RsaKeyProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class BooksApplication {

	public static void main(String[] args) {

		SpringApplication.run(BooksApplication.class, args);

	}



}
