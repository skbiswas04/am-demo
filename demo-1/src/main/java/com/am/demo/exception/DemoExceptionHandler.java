/**
 * 
 */
package com.am.demo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author sbiswas
 *
 */

@ControllerAdvice
@RestController
public class DemoExceptionHandler extends ResponseEntityExceptionHandler {
	
	/**
	 * Handles all exceptions
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<DemoExceptionResponse> handleAllxceptions(Exception ex, WebRequest request){
		
		DemoExceptionResponse demoExceptionResponse = new DemoExceptionResponse(new Date(), 
				ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<DemoExceptionResponse>(demoExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * Handles ProjectNotFound Exception
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(ProjectNotFoundException.class)
	public final ResponseEntity<DemoExceptionResponse> handleProjectNotFoundException(Exception ex, WebRequest request){
		
		DemoExceptionResponse demoExceptionResponse = new DemoExceptionResponse(new Date(), 
				ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<DemoExceptionResponse>(demoExceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Handles DepartmentNotFound Exceptions
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(DepartmentNotFoundException.class)
	public final ResponseEntity<DemoExceptionResponse> handleDepartmentNotFoundException(Exception ex, WebRequest request){
		
		DemoExceptionResponse demoExceptionResponse = new DemoExceptionResponse(new Date(), 
				ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<DemoExceptionResponse>(demoExceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Handles EmployeeNotFound Exceptions
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(EmployeetNotFoundException.class)
	public final ResponseEntity<DemoExceptionResponse> handleEmployeeNotFoundException(Exception ex, WebRequest request){
		
		DemoExceptionResponse demoExceptionResponse = new DemoExceptionResponse(new Date(), 
				ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<DemoExceptionResponse>(demoExceptionResponse, HttpStatus.NOT_FOUND);
	}

}
