package com.skkgroup.shoes.payment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChargeResponse {
    public String status;
    public String id;
    public String transactionId;
}