package com.example.demo.JWTService1;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.util.Map;
import java.util.function.Function;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;

@Service
public class JWTService 
{
	private String secretkey="";
	
	public JWTService()
	{
		try {
			KeyGenerator keyGen=KeyGenerator.getInstance("HmacSHA256");
			SecretKey sk=keyGen.generateKey();
			secretkey=Base64.getEncoder().encodeToString(sk.getEncoded());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String generateToken(String userName) 
	{
		Map<String,Object> claims=new HashMap<>();
		
		
		return Jwts.builder()
				.claims().add(claims).subject( userName)
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis()+60*2*1000))  //2 mins
				.and()
				.signWith(getkey())
				.compact();
	}

	private SecretKey getkey() {
		byte[] keyBytes=Decoders.BASE64.decode(secretkey);
		return Keys.hmacShaKeyFor(keyBytes);
	}

	public String extractUserName(String token) {
		
		return extractClaim(token,Claims::getSubject);
	}

	private<T>T extractClaim(String token, Function<Claims,T> claimResolver) {
		
		final Claims Claims=extractAllClaims(token);
		return claimResolver.apply(Claims);
	}

	private Claims extractAllClaims(String token) {
		
		 return Jwts.parser()
				 .verifyWith(getkey())
				 .build().parseSignedClaims(token)
				 .getPayload();
	}

	public boolean validateToken(String token, UserDetails userDetails)
	{
		final String userName=extractUserName(token);
		return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	private boolean isTokenExpired(String token) {
		
		return extractExpiration(token).before(new Date());
	}

	private Date extractExpiration(String token) {
		// TODO Auto-generated method stub
		return extractClaim(token, Claims::getExpiration);
	}

}
