package com.example.demo.controller.error;

import org.springframework.boot.web.servlet.error.ErrorController;

/**
 * ErrorController is mapped by url "/error".
 * @author gon
 *
 */
public class CustomErrorController implements ErrorController {

	@Override
	public String getErrorPath() {
		
		return null;
	}

}
