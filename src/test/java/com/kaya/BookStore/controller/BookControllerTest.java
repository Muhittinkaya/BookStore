package com.kaya.BookStore.controller;

import com.kaya.BookStore.dto.BookDto;
import com.kaya.BookStore.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {

    @InjectMocks
    private BookController bookController;

    @Mock
    private BookService bookService;

    @Test
    void shouldReturnBookDtoListWhenGetBooksCalled() {
        List<BookDto> bookDtos = new ArrayList<>();
        bookDtos.add(getBookDto());

        when(bookService.getBooks()).thenReturn(bookDtos);
        ResponseEntity<List<BookDto>> books = bookController.getBooks();

        assertThat(books.getBody()).isNotNull();
        assertThat(books.getBody().size()).isEqualTo(1);
    }

    private BookDto getBookDto() {
        return BookDto.builder()
                .id(UUID.randomUUID())
                .title("Test")
                .description("new book")
                .releaseYear(2020)
                .build();
    }

}
