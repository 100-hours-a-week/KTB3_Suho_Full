package com.example.spring_practice.dto;

import jakarta.validation.constraints.NotBlank;

public class BookDto {
    private Long id;
    @NotBlank(message = "제목을 입력하세요.")
    private String title;
    @NotBlank(message = "저자를 입력하세요.")
    private String author;
    @NotBlank(message = "설명을 입력하세요.")
    private String description;
    @NotBlank(message = "isbn을 입력하세요.")
    private String isbn;

    public BookDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public BookDto(Long id, String title, String author, String description, String isbn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.isbn = isbn;
    }
}
