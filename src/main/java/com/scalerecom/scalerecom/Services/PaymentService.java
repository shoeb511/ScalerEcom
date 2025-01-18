package com.scalerecom.scalerecom.Services;

import com.scalerecom.scalerecom.Models.Ordermodel;
import com.stripe.exception.StripeException;
import org.springframework.http.ResponseEntity;

public interface PaymentService {
    public String makePayment(long orderId, long amount) throws StripeException;

    //ResponseEntity<String> orderStatus(long orderId1);
}
