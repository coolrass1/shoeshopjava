package com.skkgroup.shoes.payment;

import com.skkgroup.shoes.shoemodule.Order_item;
import lombok.Data;

import java.util.Currency;
import java.util.List;

@Data
public class ChargeRequest {
    private List<Order_item > orderDetails;
    private String description;
    private Long amount;
    private String currency;
    private String token;
    private String customerAddress;
    private String street_number;
    private String fullname;
    private String companyname;

}