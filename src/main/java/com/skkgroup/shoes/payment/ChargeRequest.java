package com.skkgroup.shoes.payment;

import lombok.Data;

import java.util.Currency;

@Data
public class ChargeRequest {
    private String description;
    private Long amount;
    private String currency;
    private String token;
}