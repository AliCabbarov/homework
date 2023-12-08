package com.company.demo.util;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageUtil {
    private final MessageSource messageSource;

    public HttpServletRequest getCurrentRequest() {

        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }

    public String getMessage(String messageCode, Object... dynamicKeys) {
        try {
            return messageSource.getMessage(messageCode, dynamicKeys, getCurrentRequest().getLocale());
        } catch (NoSuchMessageException exception) {
            log.error("localize: {}", messageCode);
        }

        return messageCode;

    }
}
