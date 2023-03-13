package com.bookstore.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bookstore.entity.MyBookList;

public interface MyBookListRepo extends JpaRepository<MyBookList, Integer>{

	
}
