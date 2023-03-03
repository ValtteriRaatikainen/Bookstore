package com.example.Bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

	@Autowired
	private CategoryRepository repository;

	@RequestMapping("/categorylist")
	public String CategoryList(Model model) {
		model.addAttribute("categorys", repository.findAll());
		return "categorylist";
	}

	@RequestMapping(value = "/addcategory")
	public String addCategory(Model model) {
		model.addAttribute("categorys", new Category());
		return "addcategory";
	}
	
	// RESTful service to get all categories
    @RequestMapping(value="/jsoncategories", method = RequestMethod.GET)
    public @ResponseBody List<Category> studentListRest() {	
        return (List<Category>) repository.findAll();
    }  
    
	@RequestMapping(value = "/savecategory", method = RequestMethod.POST)
	public String saveCategory(Category category) {
		repository.save(category);
		return "redirect:categorylist";
	}
	
}
