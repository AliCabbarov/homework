package com.company.aoppaymentms.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentTransferValidateRequestDto {
    private String sourceCardNumber;
    private String targetCardNumber;
    private BigDecimal amount;
}
