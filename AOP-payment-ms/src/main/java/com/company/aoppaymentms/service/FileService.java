package com.company.aoppaymentms.service;

import com.company.aoppaymentms.model.dto.request.PaymentTransferProcessRequestDto;
import com.company.aoppaymentms.model.dto.response.PaymentTransferProcessResponseDto;

public interface FileService {
    void writeFile(PaymentTransferProcessResponseDto requestDto);
}
