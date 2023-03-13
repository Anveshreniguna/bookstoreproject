package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.entity.Book;
import com.bookstore.entity.MyBookList;
import com.bookstore.service.MyBookListService;
import com.bookstore.service.bookService;

@Controller
public class BookController {

	
	@Autowired
	private bookService bSer; 
	
	@Autowired
	private MyBookListService mbSer;
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/bookregistration")
	public String bookRegistration() {
		return "bookregistration";
	}
	
	@GetMapping("/availablebooks")
	public ModelAndView availableBooks() {
		List<Book> bList = bSer.getBookList();
		return new ModelAndView("availablebooks", "book", bList);
	}
	
	@GetMapping("/mybooks")
	public String myBooks(Model model) {
		
		List<MyBookList> list = mbSer.getMyBookList();
		model.addAttribute("book", list);
		return "mybooks";
		
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		bSer.save(b);
		return "redirect:/availablebooks";
	}
	
	@RequestMapping("/deletemylist/{id}")
	public String deleteMyBookList(@PathVariable int id) {
		mbSer.deleteById(id);
		return "redirect:/mybooks";
	}
	
	@GetMapping("/mylist/{id}")
	public String addBook(@PathVariable int id) {
		
		Book b = bSer.getBookById(id);
		MyBookList mb = new MyBookList(b.getBookId(),b.getBookName(), b.getBookAuthor(), b.getBookPrice());
		mbSer.save(mb);
		return "redirect:/mybooks";
	}
	
	@GetMapping("/editdetails/{id}")
	public String editBookDetails(@PathVariable int id, Model model) {
		
		Book b = bSer.getBookById(id);
		model.addAttribute("book", b);
		return "bookedit";
	}
	
	@GetMapping("/deletebook/{id}")
	public String deleteBook(@PathVariable int id) {
		
		bSer.deleteById(id);
		return "redirect:/availablebooks";
	}
	
	
}
