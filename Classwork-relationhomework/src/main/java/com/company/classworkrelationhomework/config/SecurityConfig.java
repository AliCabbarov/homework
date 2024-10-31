package com.company.classworkrelationhomework.config;


import com.company.classworkrelationhomework.model.constant.EndPoints;
import com.company.classworkrelationhomework.model.enums.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final AuthRequestFilter authRequestFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        security
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(
                                EndPoints.SWAGGER_V2,
                                EndPoints.SWAGGER_V3,
                                EndPoints.SWAGGER_V3_ALL,
                                EndPoints.SWAGGER_RESOURCE,
                                EndPoints.SWAGGER_RESOURCE_ALL,
                                EndPoints.SWAGGER_CONFIGURATION_UI,
                                EndPoints.SWAGGER_CONFIGURATION_SECURITY,
                                EndPoints.SWAGGER_UI,
                                EndPoints.SWAGGER_WEBJARS,
                                EndPoints.SWAGGER_UI_HTML).permitAll()
                        .requestMatchers("/admins/**").hasAnyAuthority(Roles.ADMIN.name())
                        .requestMatchers("/auth/**").permitAll()
                        .requestMatchers("/files/**").permitAll()
                        .requestMatchers("/test/**").permitAll()
                        .requestMatchers("/notification/**").permitAll()
                        .requestMatchers("/users/**").hasAnyAuthority(Roles.ADMIN.name(), Roles.USER.name())
                        .anyRequest().permitAll())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(authRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return security.build();
    }

}
