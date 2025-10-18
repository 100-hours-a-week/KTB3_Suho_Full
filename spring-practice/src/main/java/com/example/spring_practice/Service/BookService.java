package com.example.spring_practice.Service;

import com.example.spring_practice.dto.BookDto;
import com.example.spring_practice.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public List<BookDto> getAllBooks() {
        return bookRepository.findAll();
    }
    public BookDto getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found with id: "+ id));
    }
    public BookDto createBook(BookDto book) {
        return bookRepository.save(book);
    }
}
