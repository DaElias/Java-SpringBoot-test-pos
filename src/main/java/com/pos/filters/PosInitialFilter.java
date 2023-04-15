package com.pos.filters;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
@WebFilter(urlPatterns = "/*")
public class PosInitialFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println(request.getHeader("x-token"));
		System.out.println(request.getHeader("Postman-Token")); 
		
		// Validation
		if(request.getHeader("x-token").length() < 3) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST,"ERROR AUTH");
		}
		
		filterChain.doFilter(request, response);
	}
}
