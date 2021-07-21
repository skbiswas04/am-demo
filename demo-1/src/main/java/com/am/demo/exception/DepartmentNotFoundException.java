/**
 * 
 */
package com.am.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author sbiswas
 *
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class DepartmentNotFoundException  extends RuntimeException{

	public DepartmentNotFoundException(String message) {
		super(message);
	}
}
