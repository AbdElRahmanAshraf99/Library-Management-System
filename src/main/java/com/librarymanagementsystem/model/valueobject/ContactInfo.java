package com.librarymanagementsystem.model.valueobject;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Embeddable
public class ContactInfo
{
	@NotBlank
	@Email
	private String email;
	@NotBlank
	@Pattern(regexp = "^[0-9]{10}$")
	private String phoneNumber;
}