package com.kaya.BookStore.repository;

import com.kaya.BookStore.model.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.StreamSupport;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    @Sql(scripts = {"classpath:initialBookRecordForTest.sql"})
    void  shouldReturnAllFetchedBooks() {
        Iterable<Book> allBooks = bookRepository.findAll();
        Long totalBookCount = StreamSupport.stream(allBooks.spliterator(), false).count();
        Assertions.assertEquals(1, totalBookCount);
    }
}
