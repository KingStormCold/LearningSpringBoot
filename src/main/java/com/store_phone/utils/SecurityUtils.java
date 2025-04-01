package com.store_phone.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUtils {
	
	public static String getCurrentUserLogin() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		return extractPrincipal(securityContext.getAuthentication());
	}

	private static String extractPrincipal(Authentication authentication) {
		if(authentication == null) {
			return null;
		} else if(authentication.getPrincipal() instanceof UserDetails) {
			UserDetails user = (UserDetails) authentication.getPrincipal();
			return user.getUsername();
		}
		else if(authentication.getPrincipal() instanceof String) {
			return (String) authentication.getPrincipal();
		}
		return null;
	}
}
