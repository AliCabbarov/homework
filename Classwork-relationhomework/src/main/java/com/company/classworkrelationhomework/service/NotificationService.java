package com.company.classworkrelationhomework.service;

import com.company.classworkrelationhomework.model.dto.request.SmsRequestDto;

public interface NotificationService {
    SmsRequestDto sendSms(SmsRequestDto smsRequestDto);
}
