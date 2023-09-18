package com.kaya.BookStore.controller;

import com.kaya.BookStore.dto.BookDto;
import com.kaya.BookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/getBooks")
    public ResponseEntity<List<BookDto>> getBooks() {
        var books =  bookService.getBooks();

        return ResponseEntity.ok(books);
    }
}
