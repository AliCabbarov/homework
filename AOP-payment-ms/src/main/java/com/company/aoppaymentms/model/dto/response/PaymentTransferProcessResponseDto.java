package com.company.aoppaymentms.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentTransferProcessResponseDto {
    private String sourceCardNumber;
    private String targetCardNumber;
    private BigDecimal amount;
    private BigDecimal amountFee;
}
