package com.kaya.BookStore.controller;

import com.kaya.BookStore.dto.BookDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookController {

    @GetMapping("/getBooks")
    public ResponseEntity<List<BookDto>> getBooks() {
        BookDto book = BookDto.builder()
                .title("Öz Şefkat")
                .build();

        BookDto bookSecond = BookDto.builder()
                .title("Böyle Buyurdu Zerdüşt")
                .build();

        List<BookDto> books = new ArrayList<>();
        books.add(book);
        books.add(bookSecond);

        return ResponseEntity.ok(books);
    }
}
