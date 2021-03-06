package com.APIATTENDANCE.application.security;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import com.APIATTENDANCE.application.entity.User;
import com.APIATTENDANCE.application.service.UserService;

public class JwtAuthenticationTokenFilter extends UsernamePasswordAuthenticationFilter {
	private final static String TOKEN_HEADER = "authorization";

	@Autowired
	private JwtService jwtService;
	@Autowired
	private UserService userService;

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) req;
		String authToken = httpRequest.getHeader(TOKEN_HEADER); // GET token form request
		

		if (jwtService.validateTokenLogin(authToken)) { // check validate token login
			int idUser = jwtService.getIDUserFromToken(authToken);
			
			User user = userService.GetOneUser(idUser);

			if (user != null) {
		        boolean enabled = true;
		        boolean accountNonExpired = true;
		        boolean credentialsNonExpired = true;
		        boolean accountNonLocked = true;
				//create user detail
				UserDetails userDetail = new org.springframework.security.core.userdetails.User(user.getUs_username(), user.getUs_password(), enabled, accountNonExpired,
			            credentialsNonExpired, accountNonLocked, user.getAuthorities());
				//create authentication
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail,
						null, userDetail.getAuthorities());
				
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}

		}
		chain.doFilter(req, res);
	}
}

