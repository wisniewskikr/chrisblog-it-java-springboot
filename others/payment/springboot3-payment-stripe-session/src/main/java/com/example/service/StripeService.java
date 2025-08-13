package com.example.service;

import com.example.model.StripeRequest;
import com.example.model.StripeResponse;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Slf4j
public class StripeService {

    public static final String DEFAULT_CURRENCY = "PLN";
    public static final int DEFAULT_MULTIPLIER = 100;

    @Value("${stripe.secretKey}")
    private String secretKey;

    @Value("${stripe.successUrl}")
    private String successUrl;

    @Value("${stripe.cancelUrl}")
    private String cancelUrl;

    @Value("${stripe.sessionDurationInSeconds")
    private long sessionDurationInSeconds;

    public StripeResponse checkout(StripeRequest stripeRequest) {
        // Set your secret key. Remember to switch to your live secret key in production!
        Stripe.apiKey = secretKey;

        long expiresAtUnix = Instant.now().plusSeconds(sessionDurationInSeconds).getEpochSecond();

        // Create a PaymentIntent with the order amount and currency
        SessionCreateParams.LineItem.PriceData.ProductData productData =
                SessionCreateParams.LineItem.PriceData.ProductData.builder()
                        .setName(stripeRequest.getName())
                        .build();

        // Create new line item with the above product data and associated price
        SessionCreateParams.LineItem.PriceData priceData =
                SessionCreateParams.LineItem.PriceData.builder()
                        .setProductData(productData)
                        .setCurrency(stripeRequest.getCurrency() != null ? stripeRequest.getCurrency() : DEFAULT_CURRENCY)
                        .setUnitAmount(Math.multiplyExact(stripeRequest.getAmount(), DEFAULT_MULTIPLIER))
                        .build();

        // Create new line item with the above price data
        SessionCreateParams.LineItem lineItem =
                SessionCreateParams
                        .LineItem.builder()
                        .setQuantity(stripeRequest.getQuantity())
                        .setPriceData(priceData)
                        .build();

        // Create new session with the line items
        SessionCreateParams params =
                SessionCreateParams.builder()
                        .setMode(SessionCreateParams.Mode.PAYMENT)
                        .setSuccessUrl(successUrl + "?paymentId=" + stripeRequest.getPaymentId())
                        .setCancelUrl(cancelUrl + "?paymentId=" + stripeRequest.getPaymentId())
                        .addLineItem(lineItem)
                        .setExpiresAt(expiresAtUnix)
                        .build();

        // Create new session
        Session session = null;
        try {
            session = Session.create(params);
        } catch (StripeException e) {
            log.error(e.getMessage());
            return StripeResponse
                    .builder()
                    .status("FAILED")
                    .message("Payment session failed. Error: " + e.getMessage())
                    .build();
        }

        return StripeResponse
                .builder()
                .status("SUCCESS")
                .message("Payment session created")
                .sessionId(session.getId())
                .sessionUrl(session.getUrl())
                .build();

    }

}
