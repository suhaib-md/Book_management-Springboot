package com.kindle.books.book;

public record Book(Integer id, String title, String author, String isbn,String publisher, String year ,String description, String image_url, Status status) {

}
