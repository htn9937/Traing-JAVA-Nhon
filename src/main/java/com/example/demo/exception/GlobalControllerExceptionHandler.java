package com.example.demo.exception;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javassist.NotFoundException;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {
	
	public   String DEFAULT_ERROR_VIEW = "Unknown Error";

	  @ExceptionHandler(value = Exception.class)
	  public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
	    // If the exception is annotated with @ResponseStatus rethrow it and let
	    // the framework handle it - like the OrderNotFoundException example
	    // at the start of this post.
	    // AnnotationUtils is a Spring Framework utility class.
	    if (AnnotationUtils.findAnnotation
	                (e.getClass(), ResponseStatus.class) != null)
	      throw e;

	    // Otherwise setup and send the user to a default error-view.
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("exception", e);
	    mav.addObject("url", req.getRequestURL());
	    mav.setViewName(DEFAULT_ERROR_VIEW);
	    return mav;
	  }
//	  
//	  @ExceptionHandler(value = NotFoundException.class)
//	  public ModelAndView notFound(HttpServletRequest req, NotFoundException e) throws Exception {
//		    if (AnnotationUtils.findAnnotation
//		                (e.getClass(), ResponseStatus.class) != null)
//		      throw e;
//
//		    ModelAndView mav = new ModelAndView();
//		    mav.addObject("exception", e);
//		    mav.addObject("url", req.getRequestURL());
//		    mav.setViewName(DEFAULT_ERROR_VIEW);
//		    return mav;
//		  }
	  @ExceptionHandler(value = NotFoundException.class)
	  public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) {
	    ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
	        request.getDescription(false));
	    return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
}
