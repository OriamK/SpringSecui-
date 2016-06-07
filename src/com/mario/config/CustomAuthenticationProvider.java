package com.mario.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{

	@Autowired
	private CustomUserDetailServices customUserDetailServices;
	
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		
		
		String principal = authentication.getName();
		String credentials = (String) authentication.getCredentials();
		
		User user = (User) customUserDetailServices.loadUserByUsername(principal);
		
		if(user != null) {
			if(credentials.equals(user.getPassword())) {
				
				System.out.println("Login Correcto");
				return new UsernamePasswordAuthenticationToken(principal, credentials, user.getAuthorities());
			} else {
				System.out.println("Error de login "+principal);
				throw new BadCredentialsException("Error de login");
			}			
		} else {
			System.out.println("Error de login "+principal);
			throw new BadCredentialsException("Error de login");
		}
	
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
