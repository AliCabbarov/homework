package com.company.aoppaymentms.controller;

import com.company.aoppaymentms.aspect.PaymentProcess;
import com.company.aoppaymentms.model.dto.request.PaymentTransferProcessRequestDto;
import com.company.aoppaymentms.model.dto.request.PaymentTransferValidateRequestDto;
import com.company.aoppaymentms.model.dto.request.PaymentTransferValidateResponseDto;
import com.company.aoppaymentms.model.dto.response.PaymentTransferProcessResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @PostMapping("/validation")
    public PaymentTransferValidateResponseDto validatePayment(@RequestBody PaymentTransferValidateRequestDto request) {
        return new PaymentTransferValidateResponseDto(request.getSourceCardNumber()
                , request.getTargetCardNumber()
                , request.getAmount()
                , request.getAmount().multiply(BigDecimal.valueOf(0.1)));
    }

    @PostMapping("/process")
    @PaymentProcess
    public PaymentTransferProcessResponseDto processPayment(@RequestBody PaymentTransferProcessRequestDto request) {
        return new PaymentTransferProcessResponseDto(request.getSourceCardNumber(),
                request.getTargetCardNumber(),
                request.getAmount(),
                request.getAmount().multiply(new BigDecimal("0.1")));

    }
}
