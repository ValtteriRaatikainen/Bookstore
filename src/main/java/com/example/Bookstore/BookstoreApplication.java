package com.example.Bookstore;

import java.lang.System.Logger;
import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;


@SpringBootApplication
public class BookstoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
		return (args) -> {

			Category c1 = new Category("Scifi");
			Category c2 = new Category("Rikos");
			Category c3 = new Category("Seikkailu");
			
			categoryRepository.save(c1);
			categoryRepository.save(c2);
			categoryRepository.save(c3);
			
			User u1 = new User("user", "$2a$10$3fTflu0ZYVzUgqvO1CZU.uNtD1S9tTyn8dnHpBw30COR1Tf.lf9gO", "USER", "user@mail.fi");
			User u2 = new User("admin", "$2a$10$QOQ7wShmcR0I5RqimnMpcufWH8u5kO1uxB9HlnE0SpVVr31S0Pc/2", "ADMIN", "user@mail.fi");
			
			userRepository.save(u1);
			userRepository.save(u2);

			Book b1 = new Book("Testikirja", "Testi Testi", 1994, "392-4225-2354", 20.59, c1);
			Book b2 = new Book("Testikirja2", "Testi Testinen", 1995, "392-4225-1234", 22.29, c2);
			Book b3 = new Book("Testikirja3", "Testinen Testi", 1996, "392-4225-6789", 26.89, c3);

			bookRepository.save(b1);
			bookRepository.save(b2);
			bookRepository.save(b3);
		};
	}

}
