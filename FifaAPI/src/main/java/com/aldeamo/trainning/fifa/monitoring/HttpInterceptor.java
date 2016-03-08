package com.aldeamo.trainning.fifa.monitoring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * Utilitario para identificar el tipo de browser
 * @author nelson
 */
public class HttpInterceptor extends HandlerInterceptorAdapter {
	
	private final static Log log = LogFactory.getLog(HttpInterceptor.class);
	private final static String IE_PAGE = "/public/ie.html";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		return true;	
	}

}
