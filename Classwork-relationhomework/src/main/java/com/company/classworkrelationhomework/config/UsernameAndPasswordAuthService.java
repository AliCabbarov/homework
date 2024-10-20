package com.company.classworkrelationhomework.config;

import com.company.classworkrelationhomework.model.entity.Permission;
import com.company.classworkrelationhomework.model.entity.User;
import com.company.classworkrelationhomework.model.enums.ErrorCode;
import com.company.classworkrelationhomework.model.exception.BadRequestException;
import com.company.classworkrelationhomework.model.exception.UsernameNotFoundException;
import com.company.classworkrelationhomework.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsernameAndPasswordAuthService implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public Optional<Authentication> getAuthentication(HttpServletRequest httpServletRequest) {
        String header = httpServletRequest.getHeader("Authorization");
        if (header != null && header.startsWith("Basic ")) {
            try {
                String username = getUsernameAndPassword(header, true);
                String password = getUsernameAndPassword(header, false);
                User user = getUserByUsername(username);
                if (!passwordEncoder.matches(password, user.getPassword())) {
                    throw new BadRequestException(ErrorCode.INVALID_CREDENTIALS, username, password);
                }
                return Optional.of(getAuthentication(user));
            } catch (JwtException e) {
                e.printStackTrace();
                return Optional.empty();
            }
        }
        return Optional.empty();
    }
    private String getUsernameAndPassword(String header,boolean isUsername){
        String decodedHeader = new String(Base64.getDecoder().decode(header.substring(6)));
        String[] usernameAndPassword = decodedHeader.split(":");
        if (isUsername){
            return usernameAndPassword[0];
        }
        return usernameAndPassword[1];
    }

    private User getUserByUsername(String username){
        return userRepository.findByEmail(username).orElseThrow(()-> new BadRequestException(ErrorCode.INVALID_CREDENTIALS, username));
    }

    private Authentication getAuthentication(User user) {

        List<Permission> authortiyList = user.getRole().getPermission();
        authortiyList.add(new Permission(user.getRole().getRole().name()));

        List<String> authList = authortiyList.stream().map(Permission::getAuthority).toList();


        JwtCredentials credentials = new JwtCredentials();
        credentials.setId(user.getId());
        credentials.setName(user.getName());
        credentials.setType("USERNAME_AND_PASSWORD_AUTHENTICATION");
        credentials.setSurname(user.getSurname());
        credentials.setAuthority(authList);
        credentials.setStatus("SUCCESS");


        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(null, credentials, authortiyList);
        usernamePasswordAuthenticationToken.setDetails(credentials);
        return usernamePasswordAuthenticationToken;
    }
}
