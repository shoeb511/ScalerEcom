package com.scalerecom.scalerecom.Services;

import com.stripe.exception.StripeException;

public interface PaymentService {
    public String makePayment(long orderId, long amount) throws StripeException;
}
