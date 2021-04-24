package com.act.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.act.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
