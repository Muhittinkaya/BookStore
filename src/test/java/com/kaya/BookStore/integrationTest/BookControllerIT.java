package com.kaya.BookStore.integrationTest;

import com.kaya.BookStore.BookStoreApplication;
import com.kaya.BookStore.dto.BookDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(classes = BookStoreApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookControllerIT {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    @Sql(scripts = {"classpath:initialBookRecordForTest.sql"})
    void shouldReturnBooksWhenBookApiCalled() {
        BookDto[] listOfBooks = testRestTemplate
                .getForObject("http://localhost:" + port + "/api/v1/getBooks", BookDto[].class);

        assertThat(listOfBooks).isNotNull();
        assertThat(listOfBooks.length).isEqualTo(1);
    }

    @Test
    @Sql(scripts = {"classpath:initialBookRecordForTest.sql"})
    void shouldReturnBooksWhenBookApiCalled1() {
        BookDto[] listOfBooks = testRestTemplate
                .getForObject("http://localhost:" + port + "/api/v1/getBooks", BookDto[].class);

        assertThat(listOfBooks).isNotNull();
        assertThat(listOfBooks.length).isEqualTo(1);
    }
}
