package com.resourceserver.emazonreportmicroservice.configuration.services;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthenticatedUserManager {

    public Long getUserId() {
        JwtAuthenticationToken authentication = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Map<String, Object> claims = authentication.getToken().getClaims();
        return (Long) claims.get("userId");
    }

    public String getUserEmail() {
        JwtAuthenticationToken authentication = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Map<String, Object> claims = authentication.getToken().getClaims();
        return (String) claims.get("sub");
    }
}