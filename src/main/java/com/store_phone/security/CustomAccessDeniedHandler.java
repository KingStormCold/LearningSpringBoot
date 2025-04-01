package com.store_phone.security;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomAccessDeniedHandler implements AuthenticationEntryPoint{

	private static final Logger logger = LoggerFactory.getLogger(CustomAccessDeniedHandler.class);
	 
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		logger.error("Access Denied: {}", authException.getMessage());
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String jsonResponse = "{\"error\": \"Access Denied! You do not have permission.\"}";
        response.getWriter().write(jsonResponse);
		
	}

}
