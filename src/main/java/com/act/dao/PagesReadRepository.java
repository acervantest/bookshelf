package com.act.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.act.entity.PagesRead;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PagesReadRepository extends JpaRepository<PagesRead, Integer>{

    @Query(value = "SELECT pr.*" +
            " FROM pages_read pr" +
            " JOIN book_record br ON br.pages_id = pr.id" +
            " WHERE br.book_id =?1 and br.user_id =?2" +
            " ORDER BY day DESC", nativeQuery = true)
    Optional<List<PagesRead>> fetchPagesReadByBookAndUser(int bookId, int userId);
}
