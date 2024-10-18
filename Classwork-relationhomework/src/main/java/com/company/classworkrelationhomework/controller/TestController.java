package com.company.classworkrelationhomework.controller;

import com.company.classworkrelationhomework.util.list.ArraysNonNullUtil;
import io.lettuce.core.GeoArgs;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
@Slf4j
public class TestController {
    final static String[] STR_ARRAY = new String[] { "a", "b", "c", "d" };
    final static BigDecimal[] EMPTY_ARRAY = new BigDecimal[] {};
    final static String[] NULL_ARRAY = null;
    @GetMapping("/1")
    public void test1() {

        boolean nonNullArray = ArraysNonNullUtil.isArrayNullOrEmpty(STR_ARRAY);
        boolean emptyArray = ArraysNonNullUtil.isArrayNullOrEmpty(EMPTY_ARRAY);
        boolean nullArray = ArraysNonNullUtil.isArrayNullOrEmpty(NULL_ARRAY);

        log.info("\nnonNullArray -> {} \nemptyArray -> {}\nnullArray -> {}",nonNullArray,emptyArray,nullArray);
    }

    @GetMapping("/2")
    public void test2() {

        Duration durationOfHour = Duration.ofHours(1);
        Duration durationOfMinutes = Duration.ofMinutes(30);

        Duration diff = durationOfHour.minus(durationOfMinutes);

        log.info("\ndiff hours -> {}",diff.get(ChronoUnit.SECONDS));
    }
}
