package com.example.spring_practice.controller;

import com.example.spring_practice.Service.BookService;
import com.example.spring_practice.dto.BookDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String getAllBooks(Model model) {
        List<BookDto> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books/list";
    }

    @GetMapping("/{id}")
    public String getBookById(@PathVariable Long id,Model model) {
        BookDto book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "books/detail";
    }

    @GetMapping("/new")
    public String showBookForm(Model model) {
        model.addAttribute("bookDto", new BookDto());
        return "books/form";
    }

    @PostMapping
    public String createBook(@Valid @ModelAttribute("bookDto") BookDto bookDto, BindingResult result) {
        if (result.hasErrors()) {
            return "books/form";
        }
        bookService.createBook(bookDto);
        return "redirect:/books";
    }
}
