package com.librarymanagementsystem.service.impl;

import com.librarymanagementsystem.exception.*;
import com.librarymanagementsystem.model.*;
import com.librarymanagementsystem.repository.*;
import com.librarymanagementsystem.service.BorrowingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class BorrowingServiceImpl implements BorrowingService
{
	private final BookRepository bookRepository;
	private final PatronRepository patronRepository;
	private final BorrowingRecordRepository borrowingRecordRepository;

	@Override
	public void borrowBook(Long bookId, Long patronId)
	{
		Book book = bookRepository.findById(bookId).orElseThrow(() -> new EntityNotFoundException(Book.class, bookId));
		Patron patron = patronRepository.findById(patronId).orElseThrow(() -> new EntityNotFoundException(Patron.class, patronId));
		borrowingRecordRepository.findByPatronIdAndBookIdAndReturnDateIsNull(patronId, bookId).ifPresent(borrowingRecord -> {
			throw new RuntimeBusinessException(
					"Patron with id " + patronId + " already has a copy of book with id " + bookId + " which is borrowed at "
							+ borrowingRecord.getBorrowDate());
		});
		BorrowingRecord borrowingRecord = new BorrowingRecord();
		borrowingRecord.setBook(book);
		borrowingRecord.setPatron(patron);
		borrowingRecord.setBorrowDate(new Date());
		borrowingRecordRepository.save(borrowingRecord);
	}

	@Override
	public void returnBook(Long bookId, Long patronId)
	{
		if (!bookRepository.existsById(bookId))
			throw new EntityNotFoundException(Book.class, bookId);
		if (!patronRepository.existsById(patronId))
			throw new EntityNotFoundException(Patron.class, patronId);
		BorrowingRecord borrowingRecord = borrowingRecordRepository.findByPatronIdAndBookId(patronId, bookId).orElseThrow(
				() -> new EntityNotFoundException(
						"There is no borrowing records between book with id " + bookId + " and patron with id " + patronId));
		borrowingRecord.setBorrowDate(new Date());
		borrowingRecordRepository.save(borrowingRecord);
	}
}