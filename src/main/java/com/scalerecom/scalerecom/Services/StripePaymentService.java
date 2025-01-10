package com.scalerecom.scalerecom.Services;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import org.springframework.stereotype.Service;

@Service
public class StripePaymentService implements PaymentService {

    @Override
    public String makePayment(long orderId, long amount) throws StripeException {

        Stripe.apiKey = "sk_test_51PNpus09nz2IZkzkglVsaY4lZLo3ByICwLTCLA9sYZ1hVrjV9BUYEkaCiPOe8YmTrDpgGVzkrMaAD8iMYc2Susvv003OOMQLUu";

        //1 -> creating Price object
        PriceCreateParams params =
                PriceCreateParams.builder()
                        .setCurrency("INR")
                        .setUnitAmount(amount)
                        .setProductData(
                            PriceCreateParams.ProductData.builder().setName(String.valueOf(orderId)).build()
                        )
                        .build();

        Price price = Price.create(params);

        //2-> creating payment link by passing the Price class object
        PaymentLinkCreateParams linkParams =
                PaymentLinkCreateParams.builder()
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
                        .build();

        PaymentLink paymentLink = PaymentLink.create(linkParams);
        return paymentLink.getUrl();
    }
}
