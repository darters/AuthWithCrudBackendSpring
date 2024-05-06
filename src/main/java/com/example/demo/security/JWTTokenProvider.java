package com.example.demo.security;

import com.example.demo.entity.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTTokenProvider {
    public static final Logger LOG = LoggerFactory.getLogger(JWTTokenProvider.class);
    public String generateToken(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        Date now = new Date(System.currentTimeMillis());
        Date expiryToken = new Date(now.getTime() + SecurityConstants.EXPIRATION_TIME);

        String userId = Integer.toString(user.getId());
        Map<String, Object> claimsMap = new HashMap<>();
        claimsMap.put("id", userId);
        claimsMap.put("username", user.getEmail());

        return Jwts.builder()
                .subject(userId)
                .claims(claimsMap)
                .issuedAt(now)
                .expiration(expiryToken)
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET)
                .compact();

    }
//    private Key getSigningKey() {
//        byte[] keyBytes = SecurityConstants.SECRET.getBytes(StandardCharsets.UTF_8);
//        return Keys.hmacShaKeyFor(keyBytes);
//    }
    public boolean validateToken(String token) {
        try{
            Jwts.parser()
                    .setSigningKey(SecurityConstants.SECRET)
                    .build()
                    .parseSignedClaims(token);
            return true;
    } catch (SignatureException | MalformedJwtException | ExpiredJwtException | UnsupportedJwtException | IllegalArgumentException exception) {
            LOG.error(exception.getMessage());
            return false;
        }
    }

    public Integer getUserIdFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SecurityConstants.SECRET)
//                .verifyWith(SecurityConstants.SECRET)
                .build()
                .parseSignedClaims(token)
                .getPayload();
        String id = (String) claims.get("id");
        return Integer.parseInt(id);
    }
}
