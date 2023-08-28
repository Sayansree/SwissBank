package com.swisbank.bannkapp.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.swisbank.bannkapp.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	private final String SECRET_KEY="d3243c24894aefdfb72e78829eb1f47342ef7fc2d91d2c056e1c99656c539c05";
	private final long SESSION_TIME=15; //minutes
	public String extractID(String token) {
		return extractClaim(token,Claims::getSubject);
	}
	private Date extractExpiration(String token) {
		return extractClaim(token,Claims::getExpiration);
	}
	
	public String generateToken(User u) {
		Map<String,Object> claims =new HashMap<String,Object>();
		return generateToken(u.getUsername(),claims);
	}
	public boolean validate(String token,User u) {
		return extractID(token).equals(u.getUsername())&&!isTokenExpired(token);
	}
	private String generateToken(String subject,Map<String,Object> claims) {
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(subject)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+SESSION_TIME*60000))
				.signWith(getSignInKey(), SignatureAlgorithm.HS256)
				.compact();
	}
	
	private boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	
	
	private <T> T extractClaim(String token,Function<Claims,T> claimsResolver){
		final Claims claims=extractAllClaims(token);
		return claimsResolver.apply(claims);
	}
	private Claims extractAllClaims(String jwt) {
		return Jwts.parserBuilder()
				.setSigningKey(getSignInKey())
				.build().parseClaimsJws(jwt)
				.getBody();
	}
	private Key getSignInKey() {
		byte[] keyBytes =Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(keyBytes);
	}
}
