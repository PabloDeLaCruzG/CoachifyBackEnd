package com.pablodelacruz.coachify.jwt;


import java.security.Key;
import java.util.*;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private static final String SECRET_KEY="586E3272357538782F413F4428472B4B6250655368566B597033733676397924";

    public String getToken(UserDetails user) {
        try {
            return getToken(new HashMap<>(), user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getToken(Map<String, Object> extraClaims, UserDetails user) {
        try {
            return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Key getKey() {
        try {
            byte[] keyBytes=Decoders.BASE64.decode(SECRET_KEY);
            return Keys.hmacShaKeyFor(keyBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getUsernameFromToken(String token) {
        try {
            return getClaim(token, Claims::getSubject);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        try {
            final String username=getUsernameFromToken(token);
            return (username.equals(userDetails.getUsername())&& !isTokenExpired(token));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Claims getAllClaims(String token)
    {
        try {
            return Jwts
                .parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T getClaim(String token, Function<Claims,T> claimsResolver)
    {
        try {
            final Claims claims=getAllClaims(token);
            return claimsResolver.apply(claims);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Date getExpiration(String token)
    {
        try {
            return getClaim(token, Claims::getExpiration);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isTokenExpired(String token)
    {
        try {
            return getExpiration(token).before(new Date());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
