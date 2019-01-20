package com.APIATTENDANCE.application.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.APIATTENDANCE.application.util.UtilMess;

public class CustomAccessDeniedHandler implements AccessDeniedHandler{

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		
	    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
	    response.setContentType("application/json");
	    response.getWriter().write((new JSONObject(UtilMess.dialog(false, "Access Denied!")).toString() ));;
		
	}
	
}

