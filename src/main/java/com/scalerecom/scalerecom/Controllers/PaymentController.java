package com.scalerecom.scalerecom.Controllers;

import com.scalerecom.scalerecom.Dto.PaymentRequestDto;
import com.scalerecom.scalerecom.Services.PaymentService;
import com.stripe.exception.StripeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    PaymentService paymentService;
    PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<String> getPayment(@RequestBody PaymentRequestDto paymentRequestDto) throws StripeException {
        String paymentLink = paymentService.makePayment(paymentRequestDto.getOrderId(), paymentRequestDto.getAmount());
        return new ResponseEntity<>(paymentLink, HttpStatus.OK);
    }
}
