package com.example.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Bookstore.domain.BookRepository;

@Controller
public class BookController {
	@RequestMapping("/index")
	public String IndexController() {
		return "index.html";
	} 
	@Autowired
	private BookRepository repository;
	
	@RequestMapping("/booklist")
	public String BookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist.html";
	} 	
}

