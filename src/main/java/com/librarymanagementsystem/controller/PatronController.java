package com.librarymanagementsystem.controller;

import com.librarymanagementsystem.model.Patron;
import com.librarymanagementsystem.service.PatronService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patrons")
@RequiredArgsConstructor
@Validated
public class PatronController
{
	private final PatronService patronService;

	@GetMapping
	public ResponseEntity<List<Patron>> getAllPatrons()
	{
		List<Patron> patrons = patronService.getAllPatrons();
		return new ResponseEntity<>(patrons, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Patron> getPatronById(@PathVariable Long id)
	{
		Patron patron = patronService.getPatronById(id);
		if (patron != null)
			return new ResponseEntity<>(patron, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Patron> addPatron(@Valid @RequestBody Patron patron)
	{
		Patron newPatron = patronService.addPatron(patron);
		return new ResponseEntity<>(newPatron, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Patron> updatePatron(@PathVariable Long id,@Valid @RequestBody Patron patron)
	{
		Patron updatedPatron = patronService.updatePatron(id, patron);
		if (updatedPatron != null)
			return new ResponseEntity<>(updatedPatron, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePatron(@PathVariable Long id)
	{
		patronService.deletePatron(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}