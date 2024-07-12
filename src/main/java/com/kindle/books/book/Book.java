package com.kindle.books.book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record Book(
        @NotNull(message = "ID cannot be null") Integer id,
        @NotBlank(message = "Title cannot be blank") @Size(min = 1, max = 255, message = "Title must be between 1 and 255 characters") String title,
        @NotBlank(message = "Author cannot be blank") @Size(min = 1, max = 255, message = "Author must be between 1 and 255 characters") String author,
        @NotBlank(message = "ISBN cannot be blank") @Pattern(regexp = "^[0-9-]*$", message = "ISBN must be a valid format") String isbn,
        @NotBlank(message = "Publisher cannot be blank") @Size(min = 1, max = 255, message = "Publisher must be between 1 and 255 characters") String publisher,
        @NotBlank(message = "Year cannot be blank") @Pattern(regexp = "^\\d{4}$", message = "Year must be a valid year") String year,
        @NotBlank(message = "Description cannot be blank") @Size(min = 1, max = 1000, message = "Description must be between 1 and 1000 characters") String description,
        @NotBlank(message = "Image URL cannot be blank") @Size(min = 1, max = 500, message = "Image URL must be between 1 and 500 characters") String image_url,
        @NotNull(message = "Status cannot be null") Status status) {

    public Book {
        if (id < 0) {
            throw new IllegalArgumentException("ID must be greater than or equal to 0");
        }
    }

}
