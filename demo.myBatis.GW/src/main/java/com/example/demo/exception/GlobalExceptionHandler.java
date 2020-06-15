package com.example.demo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(DataAccessException.class)
	@ResponseBody
	public Map<String, String> dataServiceException(DataAccessException ex) {
		Map<String, String> errorMap = new HashMap<String, String>();
		String code = "50100";
		String msg = "[dataServiceException]" + ex.getMessage();
		errorMap.put("code", code);
		errorMap.put("message", msg);
		return errorMap;
	}
	
	@ExceptionHandler(NullPointerException.class)
	@ResponseBody
	public Map<String, String> nullpointerException(NullPointerException ex) {
		Map<String, String> errorMap = new HashMap<String, String>();
		String code = "90000";
		String msg = "[nullpointerException]" + ex.getMessage();
		errorMap.put("code", code);
		errorMap.put("message", msg);
		return errorMap;		
	}
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public Map<String, String> runtimeException(RuntimeException ex) {
		Map<String, String> errorMap = new HashMap<String, String>();
		String code = "00000";
		String msg = "[defaultException]" + ex.getMessage();
		errorMap.put("code", code);
		errorMap.put("message", msg);
		return errorMap;
	}
	
}
