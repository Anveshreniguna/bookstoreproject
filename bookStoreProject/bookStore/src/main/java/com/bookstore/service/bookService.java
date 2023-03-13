package com.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.entity.Book;
import com.bookstore.repo.BookRepository;

@Service
public class bookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	public void save(Book b) {
		bookRepo.save(b);
	}
	
	public List<Book> getBookList() {
		return bookRepo.findAll();
	}
	
	public Book getBookById(int id) {
		return bookRepo.findById(id).get();
	}
	
	public void deleteById(int id) {
		bookRepo.deleteById(id);
	}
}
