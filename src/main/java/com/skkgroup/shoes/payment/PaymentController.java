package com.skkgroup.shoes.payment;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/test")
@CrossOrigin
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @PostMapping("/charge")
    public ChargeResponse chargeCreditCard(@RequestBody ChargeRequest chargeRequest) throws StripeException {

        Charge rass=paymentService.chargeCreditCard(chargeRequest.getToken(), chargeRequest.getAmount(), chargeRequest.getCurrency(), chargeRequest.getDescription());
        System.out.println(chargeRequest.getAmount());
    return ChargeResponse.builder().transactionId(rass.getBalanceTransaction())
            .status(rass.getStatus())
            .id(rass.getId())
            .build();

    }
}
