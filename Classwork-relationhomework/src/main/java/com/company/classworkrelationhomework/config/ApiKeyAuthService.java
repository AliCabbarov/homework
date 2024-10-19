package com.company.classworkrelationhomework.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApiKeyAuthService implements AuthService {

    private final BaseJwtService baseJwtService;

    @Override
    public Optional<Authentication> getAuthentication(HttpServletRequest httpServletRequest) {
        String header = httpServletRequest.getHeader("Authorization");
        if (header != null && header.startsWith("ApiKey ")) {
            String token = header.substring(7);
            try {
                Jws<Claims> claimsJws = baseJwtService.parseToken(token);
                return Optional.of(getAuthentication(claimsJws.getPayload()));
            } catch (JwtException e) {
                e.printStackTrace();
                return Optional.empty();
            }
        }
        return Optional.empty();
    }


    private Authentication getAuthentication(Claims claims) {
        log.info("Will be mapped this jwt claims data {}",claims);

        List<String> roles = (List) claims.get("authority");
        List<GrantedAuthority> authorityList;
        authorityList = roles
                .stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        JwtCredentials credentials = new ModelMapper().map(claims, JwtCredentials.class);

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(null, credentials, authorityList);
        usernamePasswordAuthenticationToken.setDetails(credentials);
        return usernamePasswordAuthenticationToken;
    }
}
