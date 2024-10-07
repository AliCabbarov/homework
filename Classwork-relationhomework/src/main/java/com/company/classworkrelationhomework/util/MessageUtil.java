package com.company.classworkrelationhomework.util;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageUtil {
    private final MessageSource messageSource;

    public String getMessage(String key, String... args) {
        return messageSource.getMessage(key, args, LocaleContextHolder.getLocale());
    }
}
