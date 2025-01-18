package com.scalerecom.scalerecom.Controllers;

import com.scalerecom.scalerecom.Models.Ordermodel;
import com.scalerecom.scalerecom.Services.OrderService;
import com.scalerecom.scalerecom.Services.PaymentService;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.model.*;
import com.stripe.net.Webhook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/webhook")
public class WebhookController {

    private final OrderService orderService;
    PaymentService paymentService;


    public WebhookController(PaymentService paymentService, OrderService orderService) {
        this.paymentService = paymentService;
        this.orderService = orderService;
    }
    private String endpointSecret = "whsec_2822901b1a666ba468439daecd1d7f1a4ad089c25721b77b43eda40c259a2a38";
    private String orderState = "idhar";

    @PostMapping("webhook")
    public ResponseEntity<String> handleWebhook(@RequestBody String payload, @RequestHeader("Stripe-Signature") String sigHeader) throws SignatureVerificationException {
        System.out.println("webhook recieved");
        try{
            Event event = Webhook.constructEvent(payload, sigHeader, endpointSecret);

            // Deserialize the nested object inside the event
            EventDataObjectDeserializer deserializer = event.getDataObjectDeserializer();
            StripeObject stripeObject = deserializer.getObject().orElse(null);

            // Handle the event
            switch (event.getType()) {
                case "payment_intent.succeeded":
                    PaymentIntent paymentIntent = (PaymentIntent) stripeObject;
                    System.out.println("PaymentIntent was successful!");
                    System.out.println("PaymentIntent is " + paymentIntent);
                    long orderId = Long.parseLong(paymentIntent.getMetadata().get("order_id"));
                    //service method calling for updating the order status

                    orderState = orderState + orderService.orderStatus(orderId);

                    break;
                case "payment_method.attached":
                    PaymentMethod paymentMethod = (PaymentMethod) stripeObject;
                    System.out.println("PaymentMethod was attached to a Customer!");
                    break;
                // ... handle other event types
                default:
                    System.out.println("Unhandled event type: " + event.getType());
            }
        }catch (Exception ex){
            System.out.println("webhook error" + ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }


        if(orderState != null) {return ResponseEntity.ok(orderState);}
        else
        return ResponseEntity.ok("Webhook received");
    }

    public PaymentService getPaymentService() {
        return paymentService;
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public String getEndpointSecret() {
        return endpointSecret;
    }

    public void setEndpointSecret(String endpointSecret) {
        this.endpointSecret = endpointSecret;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }
}

