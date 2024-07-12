package com.kindle.books.book;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

@Repository
public class BookRepository {

    private static final Logger log = LoggerFactory.getLogger(BookRepository.class);

    private final JdbcClient jdbcClient;

    public BookRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Book> getAllBooks() {
        return jdbcClient.sql("select * from Book")
                .query(Book.class)
                .list();
    }

    public Optional<Book> findById(Integer id) {
        return jdbcClient.sql("select * from Book where id = :id")
               .param("id", id)
               .query(Book.class)
               .optional();
    }

    public void createBook(Book book) {
        var updated = jdbcClient.sql("insert into Book (id, title, author, isbn, publisher, \"year\", \"description\", image_url, \"status\") values (?,?,?,?,?,?,?,?,?)")
               .params(List.of(book.id(), book.title(), book.author(), book.isbn(), book.publisher(), book.year(), book.description(), book.image_url(), book.status().toString()))
               .update();

        Assert.state(updated==1, "Failed to create book "+ book.title());
    }

    public void updateBook(Book book, Integer id) {
        var updated = jdbcClient.sql("update Book set title =?, author =?, isbn =?, publisher =?, \"year\" =?, \"description\" =?, image_url =?, \"status\" =? where id =?")
               .params(List.of(book.title(), book.author(), book.isbn(), book.publisher(), book.year(), book.description(), book.image_url(), book.status().toString(), id))
               .update();
        
        Assert.state(updated==1, "Failed to update book "+ book.title());
    }

    public void deleteBook(Integer id) {
        var updated = jdbcClient.sql("delete from Book where id =?")
               .params(List.of(id))
               .update();

        Assert.state(updated==1, "Failed to delete book "+ id);
    }

    public int count() {
        return jdbcClient.sql("select * from Book")
               .query().listOfRows().size();
    }

    public void saveAll(List<Book> books) {
        books.stream().forEach(this::createBook);
    }

    public List<Book> findByStatus(Status status) {
        return jdbcClient.sql("select * from Book where status =?")
               .params(List.of(status.toString()))
               .query(Book.class)
               .list();
    }


}
