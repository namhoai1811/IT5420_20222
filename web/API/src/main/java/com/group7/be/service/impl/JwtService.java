package com.group7.be.service.impl;

import com.group7.be.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {
    private final String SECRET_KEY;
    private final Long EXPIRE_TIME;

    public Logger logger = LoggerFactory.getLogger(JwtService.class);

    public JwtService(@Value("${jwt_secret_key}")String secret_key, @Value("${jwt_expire_time}") String expire_time) {
        SECRET_KEY = secret_key;
        EXPIRE_TIME = Long.valueOf(expire_time);
    }

    public String generateToken(User user, Map<String, Object> claims) {
        Date now = new Date(System.currentTimeMillis());
        Date expire = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(user.getUsername())
                .setIssuedAt(now)
                .setExpiration(expire)
                .signWith(getSignKey(SECRET_KEY), SignatureAlgorithm.HS256)
                .compact();
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignKey(SECRET_KEY))
                .build().parseClaimsJws(token)
                .getBody();
    }

    public String getUserName(String token) {
        return extractAllClaims(token).getSubject();
    }
    public boolean isValidToken(String token, UserDetails userDetails) {
        String username = getUserName(token);

        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private Date getExpiration(String token) {
        return extractAllClaims(token).getExpiration();
    }

    private boolean isTokenExpired(String token) {
        return getExpiration(token).before(new Date());
    }

    public SecretKey getSignKey(String secretKey) {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
    }

}
