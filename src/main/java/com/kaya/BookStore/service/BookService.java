package com.kaya.BookStore.service;

import com.kaya.BookStore.dto.BookDto;
import com.kaya.BookStore.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookService {

    @Autowired
    private final BookRepository bookRepository;
    @Autowired
    private final ModelMapper modelMapper;

    public BookService(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    public List<BookDto> getBooks() {
        var books = bookRepository.findAll();

        return StreamSupport.stream(books.spliterator(), false)
                .map(book -> modelMapper.map(books, BookDto.class))
                .collect(Collectors.toList());
    }
}
