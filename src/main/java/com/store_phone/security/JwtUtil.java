package com.store_phone.security;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	
	private final String SECRET_KEY = "ZWRkYzNkMThjOWY4NzRhN2M1M2UxZWU3ZTljYTAxNmU0ODUwMWYzNzY0ODdjNjliZjE1ZmU3MmI1NGM1NTE4YWViZTJiNzZmYzZjMzc5YTY3MWRmNzAyMjFlNDU0OWI5YTcyNWZiNWY1YjliZjRmNDU0Yzk2NzA3MWUzZTM3Yjg=";
    private final long EXPIRATION_TIME = 86400000; // 1 day
    public static final String AUTHORIZATION_HEADER = "Authorization";

    @SuppressWarnings("deprecation")
	public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token, String username) {
        return extractUsername(token).equals(username) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration()
                .before(new Date());
    }

}
