package com.company.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@ToString
public class Airport {
    private long id;
    @Setter
    private String name;
    @Setter
    private String area;
    private double totalAmount;



    public void incrementTotalAmount(double totalAmount) {
        this.totalAmount = this.totalAmount + totalAmount;
    }
    public void decrementTotalAmount(double totalAmount){
        this.totalAmount = this.totalAmount - totalAmount;
    }
}
