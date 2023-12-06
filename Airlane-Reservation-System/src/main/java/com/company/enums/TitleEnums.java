package com.company.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TitleEnums {
    DATE_FLIGHT("date flight"),
    DATE_BIRTHDAY("date birthday");
    private final String message;


}
