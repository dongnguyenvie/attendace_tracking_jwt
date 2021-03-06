package com.APIATTENDANCE.application.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.APIATTENDANCE.application.util.UtilMess;

public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint{

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		// response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	    response.setContentType("application/json");
	    response.getWriter().write((new JSONObject(UtilMess.dialog(false, "Unauthorized!")).toString() ));;
	}

}
