package com.study.ecommerce.jwt;

import com.study.ecommerce.model.user.UserDetailsCustom;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = -2550185165626007488L;

    private static final long JWT_TOKEN_VALIDITY = 5*60*60;

    @Value("${spring.security.jwt.secret}")
    private String secret;

    private Key key;

    @PostConstruct
    protected void init() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        this.key = Keys
                .hmacShaKeyFor(keyBytes);
    }

    public String generateToken(UserDetailsCustom userDetails) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + 86400000);
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    public String getUsernameFromJWT(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token) {
         Jws<Claims> jws = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
        return isTokenNonExpired(jws.getBody().getExpiration());

    }

    private boolean isTokenNonExpired(Date expiration) {
        return expiration.after(new Date());
    }

    public String getTokenFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        return StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")
                ? bearerToken.substring(7) : null;
    }
}
