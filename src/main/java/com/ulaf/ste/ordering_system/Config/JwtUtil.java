package com.ulaf.ste.ordering_system.Config;

import com.ulaf.ste.ordering_system.Model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
    private final Key signingKey;

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private int expirationTime;
    public JwtUtil() {
        signingKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    }
    public String generateToken(User user) {
        // Create the JWT claims
        Claims claims = Jwts.claims().setSubject(user.getUsername());

        // Generate the JWT token
        return Jwts.builder()
                .setClaims(claims)
                .signWith(signingKey, SignatureAlgorithm.HS512)
                .compact();
    }
    //TODO: FIX DEPRECATEDS
    public Long getUserIdFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();

        return Long.parseLong(claims.getSubject());
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}