package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Bookstore.web.BookController;
import com.example.Bookstore.web.CategoryController;
import com.example.Bookstore.web.UserDetailsServiceImpl;

@SpringBootTest
class BookstoreApplicationTests {

    @Autowired
    private BookController bookController;

    @Autowired
    private CategoryController categoryController;

    @Autowired
    private UserDetailsServiceImpl userDetailController;

    @Test
    public void bookControllerTest() {
        assertThat(bookController).isNotNull();
    }

    @Test
    public void categoryControllerTest() {
        assertThat(categoryController).isNotNull();
    }

    @Test
    public void userDetailServiceImplTest() {
        assertThat(userDetailController).isNotNull();
    }
}
