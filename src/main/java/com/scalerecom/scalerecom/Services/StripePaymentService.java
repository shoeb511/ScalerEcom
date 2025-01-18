//package com.scalerecom.scalerecom.Services;
//
//import com.stripe.Stripe;
//import com.stripe.exception.StripeException;
//import com.stripe.model.PaymentIntent;
//import com.stripe.model.PaymentLink;
//import com.stripe.model.Price;
//import com.stripe.param.PaymentIntentCreateParams;
//import com.stripe.param.PaymentLinkCreateParams;
//import com.stripe.param.PriceCreateParams;
//import org.springframework.stereotype.Service;
//
//@Service
//public class StripePaymentService implements PaymentService {
//
//    OrderService orderService;
//    public StripePaymentService(OrderService orderService) {
//        this.orderService = orderService;
//    }
//
//
//
//    //creating price object for generating payment link
//    @Override
//    public String makePayment(long orderId, long amount) throws StripeException {
//
//        Stripe.apiKey = "sk_test_51Qg2kJAZYzBCgUSnYCkMjztHsemNLhMtRIuYHfzFimFdw3kc1Swgk3mJTYR1JCn0r9xrJX7uoawX5NosXIiozwsV00MV5A7xCp";
//
//        //creating payment indent
//        PaymentIntentCreateParams intentParams = PaymentIntentCreateParams.builder()
//                .setAmount(amount)
//                .setCurrency("INR")
//                .putMetadata("order_id",
//                String.valueOf(orderId)) .build();
//        PaymentIntent paymentIntent = PaymentIntent.create(intentParams);
//
//        //1 -> creating Price object
//        PriceCreateParams params =
//                PriceCreateParams.builder()
//                        .setCurrency("INR")
//                        .setUnitAmount(amount)
//                        .setProductData(
//                            PriceCreateParams.ProductData.builder().setName(String.valueOf(orderId)).build()
//                        )
//                        .build();
//
//        Price price = Price.create(params);
//
//
//        //2-> creating payment link by passing the Price class object
//        PaymentLinkCreateParams linkParams =
//                PaymentLinkCreateParams.builder()
//                        .addLineItem(
//                                PaymentLinkCreateParams.LineItem.builder()
//                                        .setPrice(price.getId())
//                                        .setQuantity(1L)
//                                        .build()
//                        ).setAfterCompletion(
//                                PaymentLinkCreateParams.AfterCompletion.builder()
//                                        .setType(PaymentLinkCreateParams.AfterCompletion.Type.REDIRECT)
//                                        .setRedirect(
//                                                PaymentLinkCreateParams.AfterCompletion.Redirect.builder()
//                                                        .setUrl("https://probz.ai")
//                                                        .build()
//                                        )
//                                        .build()
//                        )
//                        .putMetadata("order_id", String.valueOf(orderId))
//                        .putMetadata("payment_intent_id", paymentIntent.getId())
//                        .build();
//
//
//        PaymentLink paymentLink = PaymentLink.create(linkParams);
//        String paymentlink = paymentLink.getUrl();
//        String paymnetIntentid = paymentIntent.getId();
//        return paymentlink +" "+paymnetIntentid;
//    }
//
//    //webhook service to change the order status if the payment has been succeeded
//
//}
package com.scalerecom.scalerecom.Services;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentIntentCreateParams;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import org.springframework.stereotype.Service;

@Service
public class StripePaymentService implements PaymentService {

    private final OrderService orderService;

    public StripePaymentService(OrderService orderService) {
        this.orderService = orderService;
    }

    // Creating price object for generating payment link
    @Override
    public String makePayment(long orderId, long amount) throws StripeException {

        Stripe.apiKey = "sk_test_51Qg2kJAZYzBCgUSnYCkMjztHsemNLhMtRIuYHfzFimFdw3kc1Swgk3mJTYR1JCn0r9xrJX7uoawX5NosXIiozwsV00MV5A7xCp";

        // 1. Create PaymentIntent with metadata
        PaymentIntentCreateParams intentParams = PaymentIntentCreateParams.builder()
                .setAmount(amount)
                .setCurrency("INR")
                .putMetadata("order_id", String.valueOf(orderId))
                .build();
        PaymentIntent paymentIntent = PaymentIntent.create(intentParams);

        // 2. Create Price object
        PriceCreateParams priceParams = PriceCreateParams.builder()
                .setCurrency("INR")
                .setUnitAmount(amount)
                .setProductData(
                        PriceCreateParams.ProductData.builder().setName(String.valueOf(orderId)).build()
                )
                .build();

        Price price = Price.create(priceParams);

        // 3. Create PaymentLink using the Price object and PaymentIntent metadata
        PaymentLinkCreateParams linkParams = PaymentLinkCreateParams.builder()
                .addLineItem(
                        PaymentLinkCreateParams.LineItem.builder()
                                .setPrice(price.getId())
                                .setQuantity(1L)
                                .build()
                ).setAfterCompletion(
                        PaymentLinkCreateParams.AfterCompletion.builder()
                                .setType(PaymentLinkCreateParams.AfterCompletion.Type.REDIRECT)
                                .setRedirect(
                                        PaymentLinkCreateParams.AfterCompletion.Redirect.builder()
                                                .setUrl("https://probz.ai")
                                                .build()
                                )
                                .build()
                )
                .putMetadata("order_id", String.valueOf(orderId))
                .putMetadata("payment_intent_id", paymentIntent.getId())
                .build();

        PaymentLink paymentLink = PaymentLink.create(linkParams);
        String paymentLinkUrl = paymentLink.getUrl();
        String paymentIntentId = paymentIntent.getId();

        return paymentLinkUrl + " " + paymentIntentId;
    }
}
