package com.librarymanagementsystem.controller;

import com.librarymanagementsystem.service.BorrowingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BorrowingController
{
	private final BorrowingService borrowingService;

	@PostMapping("/borrow/{bookId}/patron/{patronId}")
	public ResponseEntity<Void> borrowBook(@PathVariable Long bookId, @PathVariable Long patronId)
	{
		borrowingService.borrowBook(bookId, patronId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/return/{bookId}/patron/{patronId}")
	public ResponseEntity<Void> returnBook(@PathVariable Long bookId, @PathVariable Long patronId)
	{
		borrowingService.returnBook(bookId, patronId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}