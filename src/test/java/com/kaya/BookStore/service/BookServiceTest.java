package com.kaya.BookStore.service;

import com.kaya.BookStore.dto.BookDto;
import com.kaya.BookStore.model.Book;
import com.kaya.BookStore.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private ModelMapper modelMapper;

    @Test
    void shouldReturnAllBooksWhenGetBooksCalled() {
        List<Book> books = new ArrayList<>();
        Book book = getBook();
        BookDto bookDto = getBookDto();
        books.add(book);

        when(bookRepository.findAll()).thenReturn(books);
        when(modelMapper.map(books, BookDto.class)).thenReturn(bookDto);
        List<BookDto> bookList = bookService.getBooks();

        assertThat(1).isEqualTo(bookList.size());
        assertThat(bookList.get(0))
                .isNotNull()
                .hasFieldOrPropertyWithValue("title", "Test")
                .hasFieldOrPropertyWithValue("description", "new book")
                .hasFieldOrPropertyWithValue("releaseYear", 2020);
    }

    private Book getBook() {
        return Book.builder()
                .id(UUID.randomUUID())
                .title("Test")
                .description("new book")
                .releaseYear(2020)
                .build();
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
