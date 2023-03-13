package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.entity.Book;
import com.bookstore.entity.MyBookList;
import com.bookstore.repo.MyBookListRepo;

@Service
public class MyBookListService {
	
	@Autowired
	private MyBookListRepo mbList;
	
	public void save(MyBookList mb) {
		mbList.save(mb);
	}
	
	public List<MyBookList> getMyBookList() {
		return mbList.findAll();
	}
	
	public void deleteById(int id) {
		mbList.deleteById(id);
	}
}
