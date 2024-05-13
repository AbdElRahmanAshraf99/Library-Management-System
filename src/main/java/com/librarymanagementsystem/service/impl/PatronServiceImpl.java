package com.librarymanagementsystem.service.impl;

import com.librarymanagementsystem.model.Patron;
import com.librarymanagementsystem.repository.PatronRepository;
import com.librarymanagementsystem.service.PatronService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatronServiceImpl implements PatronService
{
	private final PatronRepository patronRepository;

	@Override
	public List<Patron> getAllPatrons()
	{
		return patronRepository.findAll();
	}

	@Override
	public Patron getPatronById(Long id)
	{
		return patronRepository.findById(id).orElse(null);
	}

	@Override
	public Patron addPatron(Patron patron)
	{
		return patronRepository.save(patron);
	}

	@Override
	public Patron updatePatron(Long id, Patron patron)
	{
		if (!patronRepository.existsById(id))
			return null;
		patron.setId(id);
		return patronRepository.save(patron);
	}

	@Override
	public void deletePatron(Long id)
	{
		patronRepository.deleteById(id);
	}
}
