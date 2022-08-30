package com.eshopping.profile.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class InvalidEmailFormatException extends RuntimeException {
	
	private String message;
	

}
