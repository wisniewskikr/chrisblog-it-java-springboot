package com.example.controller;

import com.example.model.StripeRequest;
import com.example.model.StripeResponse;
import com.example.service.StripeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/checkout")
@AllArgsConstructor
public class CheckoutController {

    private final StripeService stripeService;

    @PostMapping
    public ResponseEntity<StripeResponse> checkout(@RequestBody StripeRequest stripeRequest) {

        StripeResponse stripeResponse = stripeService.checkout(stripeRequest);
        return "SUCCESS".equals(stripeResponse.getStatus()) ? ResponseEntity.ok(stripeResponse) : ResponseEntity.badRequest().body(stripeResponse);

    }

}
