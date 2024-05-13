package com.librarymanagementsystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class Book
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(max = 100)
	private String title;
	@NotBlank
	private String author;
	@NotNull
	private int publicationYear;
	@NotBlank
	@Pattern(regexp = "\\d{3}-\\d{10}")
	private String isbn;
}
