package com.librarymanagementsystem.model;

import com.librarymanagementsystem.model.valueobject.ContactInfo;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class Patron
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(max = 100)
	private String name;
	@Valid
	@Embedded
	private ContactInfo contactInfo;
}
