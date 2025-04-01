package com.store_phone.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.store_phone.security.CustomAccessDeniedHandler;
import com.store_phone.security.JwtFilter;

@Configuration
@EnableWebSecurity
//@EnableMethodSecurity
public class SecurityConfig {
	
	private final UserDetailsService userDetailsService;
	private final JwtFilter jwtFilter;
	
	public SecurityConfig(UserDetailsService userDetailsService, JwtFilter jwtFilter) {
		this.userDetailsService = userDetailsService;
		this.jwtFilter = jwtFilter;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		return new ProviderManager(List.of(provider));
	}
	
	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
			.csrf()
			.disable()
			.authorizeHttpRequests(auth -> auth
					.requestMatchers("/api/login", "/api/logout").permitAll()
//					.requestMatchers("/v1/user**").hasAuthority("ADMIN_CATEGORY")
					.anyRequest().authenticated()
				)
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
				.exceptionHandling(exception -> exception
						.authenticationEntryPoint(new CustomAccessDeniedHandler())
				)
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
			;
		
		return http.build();
	}

}
