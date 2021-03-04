package com.bankline.bankline.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.bankline.bankline.data.enums.RoleEnum;
import com.bankline.bankline.data.model.UsuarioLogin;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTUtil {

    private static final SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    @Value("10000000")
    private Long JWT_VALIDITY;

    public String generateToken(UsuarioLogin user) {
        final Map<String, Object> claims = new HashMap<>();
        claims.put("usrid", user.getId());
        claims.put("role", user.getRole());
        return Jwts.builder()
            .setClaims(claims)
            .setSubject(user.getUsername())
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + JWT_VALIDITY))
            .signWith(key)
            .compact();
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .getBody();
    }

    public String getSubject(String token) {
        return getClaims(token).getSubject();
    }

    public Date getExpirationDate(String token) {
        return getClaims(token).getExpiration();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDate(token);
        return expiration.before(new Date());
    }

    public Boolean validateToken(String token) {
        return (getClaims(token) != null && !isTokenExpired(token));
    }

    public UsuarioLogin getUser(String token) {
        final Claims claims = getClaims(token);
        final Long id = claims.get("usrid", Long.class);
        final String username = claims.getSubject();
        final RoleEnum role = RoleEnum.valueOf(claims.get("role", String.class));
        return UsuarioLogin.builder()
            .id(id)
            .username(username)
            .role(role)
            .build();
    }
}
