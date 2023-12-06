package com.company.aoppaymentms.aspect;

import com.company.aoppaymentms.model.dto.response.PaymentTransferProcessResponseDto;
import com.company.aoppaymentms.model.exception.ExceptionResponse;
import com.company.aoppaymentms.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@Slf4j
@RequiredArgsConstructor
@Aspect
public class LogAspect {
    private final FileService fileService;

    @Around("allPaymentMethods()")
    @SneakyThrows
    public Object logAllPayments(ProceedingJoinPoint point) {
        try {
            log.info("POST - Payment with {} request : {}", point.getSignature().getName(), List.of(point.getArgs()));

            Object proceed = point.proceed();

            log.info("POST - Payment with {} response: {}", point.getSignature().getName(), proceed);
            return proceed;

        } catch (Throwable ex) {
            log.error("POST - Payment with {} failed : {}", point.getSignature().getName(), ex.getMessage());
            return new ExceptionResponse(ex.getMessage());
        }
    }

    @AfterReturning(value = "processPayment()", returning = "result")
    private void savePaymentProcess(PaymentTransferProcessResponseDto result) {
        fileService.writeFile(result);
        log.info("writing operation saved!");
    }

    @Pointcut("execution(* com.company.aoppaymentms.controller.PaymentController.*Payment(..))")
    public void allPaymentMethods() {
    }

    @Pointcut("@annotation(PaymentProcess)")
    public void processPayment() {
    }
}
