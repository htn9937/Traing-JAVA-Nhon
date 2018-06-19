package com.example.demo.exception;

import java.util.Date;

//import org.joda.time.DateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//import com.example.demo.common.LogUtils;

//@ControllerAdvice
public class BaseControllerExceptionHandler extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	@ExceptionHandler(value = DataNotFoundException.class)
	@ResponseBody
	public ResponseEntity<ApiExceptionDetails> notFound(DataNotFoundException e) {
//		LogUtils.Error(this.getClass(), e.getMessage());
		ApiExceptionDetails responseMessage = new ApiExceptionDetails(new Date(),"404","Data Not Found",e.getMessage());
		return new ResponseEntity<ApiExceptionDetails>(responseMessage, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = BadRequestException.class)
	@ResponseBody
	public ResponseEntity<ApiExceptionDetails> BadRequest(BadRequestException e) {
//		LogUtils.Error(this.getClass(), e.getMessage());
		ApiExceptionDetails responseMessage = new ApiExceptionDetails(new Date(),"400","Bad Request",e.getMessage());
		return new ResponseEntity<ApiExceptionDetails>(responseMessage, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = ForbiddenException.class)
	@ResponseBody
	public ResponseEntity<ApiExceptionDetails> forbidden(ForbiddenException e) {
//		LogUtils.Error(this.getClass(), e.getMessage());
		ApiExceptionDetails responseMessage = new ApiExceptionDetails(new Date(),"403","Not authentincation",e.getMessage());
		return new ResponseEntity<ApiExceptionDetails>(responseMessage, HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ResponseEntity<ApiExceptionDetails> internal(Exception e) {
//		LogUtils.Error(this.getClass(), e.getMessage());
		ApiExceptionDetails responseMessage = new ApiExceptionDetails(new Date(),"500","Internal Server Errorr",e.getMessage());
		return new ResponseEntity<ApiExceptionDetails>(responseMessage, HttpStatus.FORBIDDEN);
	}
}
