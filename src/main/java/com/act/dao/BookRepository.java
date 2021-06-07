package com.act.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.act.entity.Book;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;


public interface BookRepository extends JpaRepository<Book, Integer>{

    @Query(value = "SELECT distinct b.* " +
            "FROM book b " +
            "JOIN book_record br on br.book_id = b.id " +
            "JOIN user u on br.user_id = u.id " +
            "WHERE user_id=?1 " +
            "ORDER BY title", nativeQuery = true)
    Optional<List<Book>> fetchBooksDtoByUserId(int userId);
}
