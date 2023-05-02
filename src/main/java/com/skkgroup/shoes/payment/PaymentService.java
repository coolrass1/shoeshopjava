package com.skkgroup.shoes.payment;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.param.ChargeCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Value("${CLIENT_SECRET}")
    private  String keys;
    public Charge chargeCreditCard(String token, Long amount, String currency, String description) throws StripeException {
                Stripe.apiKey = keys;

        ChargeCreateParams params =
                ChargeCreateParams.builder()
                        .setAmount(amount)
                        .setCurrency(currency)
                        .setDescription(description)
                        .setSource(token)
                        .build();
        return Charge.create(params);
    }
}

