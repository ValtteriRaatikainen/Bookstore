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
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {

			Category c1 = new Category("Scifi");
			Category c2 = new Category("Rikos");
			Category c3 = new Category("Seikkailu");
			
			categoryRepository.save(c1);
			categoryRepository.save(c2);
			categoryRepository.save(c3);

			Book b1 = new Book("Testikirja", "Testi Testi", 1994, "392-4225-2354", 20.59, c1);
			Book b2 = new Book("Testikirja2", "Testi Testinen", 1995, "392-4225-1234", 22.29, c2);
			Book b3 = new Book("Testikirja3", "Testinen Testi", 1996, "392-4225-6789", 26.89, c3);

			bookRepository.save(b1);
			bookRepository.save(b2);
			bookRepository.save(b3);
		};
	}

}
