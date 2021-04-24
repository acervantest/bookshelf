package com.act.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.act.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
