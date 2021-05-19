package com.act.dao;

import com.act.entity.BookRecord;
import com.act.entity.BookRecordId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRecordRepository extends JpaRepository<BookRecord, BookRecordId> {
}
