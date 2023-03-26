package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest

public class BookstoreRepositoryTests{

		@Autowired
		private BookRepository bookRepository;
		@Autowired
		private CategoryRepository categoryRepository;
		
		@Test
		public void findByBookTitleShouldReturnAuthor() {
			List<Book> books = bookRepository.findByTitle("Testikirja");
			assertThat(books).hasSize(1);
			assertThat(books.get(0).getAuthor()).isEqualTo("Testi Testi");
		}
		
		@Test
		public void findByBookIdShouldReturnAuthor() {
			List<Book> books = bookRepository.findById(1);
			assertThat(books).hasSize(1);
			assertThat(books.get(0).getAuthor()).isEqualTo("Testi Testi");
		}
		
		@Test
		public void findByBookAuthorShouldReturnPrice() {
			List<Book> books = bookRepository.findByAuthor("Testi Testinen");
			assertThat(books).hasSize(1);
			assertThat(books.get(0).getPrice()).isEqualTo(22.29);
		}
		
		@Test
		public void createNewBook() {
		Category c4 = new Category("Fantasia"); 
		Book book = new Book("Luotu testikirja", "Testien Luoja", 2022, "321-5742-8573", 20.59, c4);
		bookRepository.save(book);
		assertThat(book.getId()).isNotNull();
		}
		
		
		@Test
		public void findByCategoryNameShouldReturnCategoryId() {
		List <Category> categorys = categoryRepository.findByName("Seikkailu");
		assertThat(categorys).hasSize(1);
		assertThat(categorys.get(0).getCategoryId()).isEqualTo(3);
		}
	}
