package com.company.classworkrelationhomework.controller;

import com.company.classworkrelationhomework.model.dto.request.SmsRequestDto;
import com.company.classworkrelationhomework.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;
    @PostMapping("/sms")
    public ResponseEntity<SmsRequestDto> sendSms(@RequestBody SmsRequestDto smsRequestDto){
        return ResponseEntity.ok(notificationService.sendSms(smsRequestDto));
    }
}
