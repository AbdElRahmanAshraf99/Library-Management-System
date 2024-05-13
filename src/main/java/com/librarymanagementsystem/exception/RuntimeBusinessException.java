package com.librarymanagementsystem.exception;

import java.util.Map;

public class RuntimeBusinessException extends RuntimeException
{
	public RuntimeBusinessException(String message)
	{
		super(message);
	}

	public Map<String, String> toMap()
	{
		return Map.of("message", getMessage());
	}
}
