package com.eshopping.profile.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class InvalidUsernameFormatException extends RuntimeException {
	
	private String message;

}
