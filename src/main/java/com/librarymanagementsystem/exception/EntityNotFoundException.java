package com.librarymanagementsystem.exception;

import java.util.Map;

public class EntityNotFoundException extends RuntimeException
{
	public EntityNotFoundException(Class<?> clazz, Long id)
	{
		super("Not found " + clazz.getSimpleName() + " with id " + id);
	}

	public EntityNotFoundException(String message)
	{
		super(message);
	}

	public Map<String, String> toMap()
	{
		return Map.of("message", getMessage());
	}
}
