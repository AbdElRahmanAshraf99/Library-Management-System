package com.librarymanagementsystem.repository;

import com.librarymanagementsystem.model.BorrowingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord, Long>
{
	Optional<BorrowingRecord> findByPatronIdAndBookId(Long patronId, Long bookId);

	Optional<BorrowingRecord> findByPatronIdAndBookIdAndReturnDateIsNull(Long patronId, Long bookId);
}