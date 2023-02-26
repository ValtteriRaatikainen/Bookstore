package com.example.Bookstore;

import java.lang.System.Logger;

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
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book b1 = new Book("Testikirja", "Testi Testi", 1994, "392-4225-2354", 20.59);
			Book b2 = new Book("Testikirja2", "Testi Testinen", 1995, "392-4225-1234", 22.29);
			Book b3 = new Book("Testikirja3", "Testinen Testi", 1996, "392-4225-6789", 26.89);

			repository.save(b1);
			repository.save(b2);
			repository.save(b3);

		};
	}

	@Bean
	public CommandLineRunner demo2(CategoryRepository repository) {
		return (args) -> {
			Category c1 = new Category(null, "Scifi");
			Category c2 = new Category(null, "Rikos");
			Category c3 = new Category(null, "Seikkailu");

			repository.save(c1);
			repository.save(c2);
			repository.save(c3);

		};
	}
}
