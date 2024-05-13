package com.librarymanagementsystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class BorrowingRecord
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Book book;
	@ManyToOne
	private Patron patron;
	@Temporal(TemporalType.DATE)
	private Date borrowDate;
	@Temporal(TemporalType.DATE)
	private Date returnDate;
}
