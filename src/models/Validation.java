package models;

import exceptions.RequiredException;

public class Validation {

	public static String required(String s, String errorValue) throws RequiredException {
		if (s.isBlank() || s.isEmpty() || s.equals("")) {
			throw new RequiredException(errorValue);
		} else {
			return s;
		}
	}
}
