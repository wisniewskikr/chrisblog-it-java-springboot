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

import java.util.List;

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

    public StripeResponse checkout(List<StripeRequest> stripeRequests) {
        // Set your secret key. Remember to switch to your live secret key in production!
        Stripe.apiKey = secretKey;

        // Convert List<StripeRequest> to List<SessionCreateParams.LineItem>
        List<SessionCreateParams.LineItem> lineItems = stripeRequests.stream()
                .map(req -> {
                    // Product data
                    SessionCreateParams.LineItem.PriceData.ProductData productData =
                            SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                    .setName(req.getName())
                                    .build();

                    // Price data
                    SessionCreateParams.LineItem.PriceData priceData =
                            SessionCreateParams.LineItem.PriceData.builder()
                                    .setProductData(productData)
                                    .setCurrency(req.getCurrency() != null ? req.getCurrency() : DEFAULT_CURRENCY)
                                    .setUnitAmount(Math.multiplyExact(req.getAmount(), DEFAULT_MULTIPLIER))
                                    .build();

                    // Line item
                    return SessionCreateParams.LineItem.builder()
                            .setQuantity(req.getQuantity())
                            .setPriceData(priceData)
                            .build();
                })
                .toList();

        // Create session params with all line items
        SessionCreateParams params =
                SessionCreateParams.builder()
                        .setMode(SessionCreateParams.Mode.PAYMENT)
                        .setSuccessUrl(successUrl) // You might need a different strategy for successUrl if IDs vary
                        .setCancelUrl(cancelUrl)
                        .addAllLineItem(lineItems)
                        .build();

        // Create new session
        Session session;
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
