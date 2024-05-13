package com.librarymanagementsystem.service.impl;

import com.librarymanagementsystem.model.Book;
import com.librarymanagementsystem.repository.BookRepository;
import com.librarymanagementsystem.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService
{
	private final BookRepository bookRepository;

	@Override
	public List<Book> getAllBooks()
	{
		return bookRepository.findAll();
	}

	@Override
	public Book getBookById(Long id)
	{
		return bookRepository.findById(id).orElse(null);
	}

	@Override
	public Book addBook(Book book)
	{
		return bookRepository.save(book);
	}

	@Override
	public Book updateBook(Long id, Book book)
	{
		if (bookRepository.existsById(id))
		{
			book.setId(id);
			return bookRepository.save(book);
		}
		return null;
	}

	@Override
	public void deleteBook(Long id)
	{
		bookRepository.deleteById(id);
	}
}
