package com.kaya.BookStore.controller;

import com.kaya.BookStore.dto.BookDto;
import com.kaya.BookStore.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(value = "Book Api", tags = "Book Api", produces = "application/json")
@RestController
@RequestMapping("/api/v1")
public class BookController {

    @Autowired
    private BookService bookService;

    @ApiOperation(value = "get list of books", response = BookDto[].class, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list of book"),
            @ApiResponse(code = 403, message = "Accessing the resource is forbidden"),
            @ApiResponse(code = 404, message = "Resource not found")
    })
    @GetMapping("/getBooks")
    public ResponseEntity<List<BookDto>> getBooks() {
        var books =  bookService.getBooks();

        return ResponseEntity.ok(books);
    }
}
