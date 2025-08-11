package com.example.controller;

import com.example.model.StripeRequest;
import com.example.model.StripeResponse;
import com.example.service.StripeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class CheckoutController {

    private final StripeService stripeService;

    @PostMapping("/checkout")
    public ResponseEntity<StripeResponse> checkout(@RequestBody StripeRequest stripeRequest) {

        StripeResponse stripeResponse = stripeService.checkout(stripeRequest);
        return "SUCCESS".equals(stripeResponse.getStatus()) ? ResponseEntity.ok(stripeResponse) : ResponseEntity.badRequest().body(stripeResponse);

    }

    @GetMapping("/success")
    public ResponseEntity<String> success() {
        return ResponseEntity.ok("Payment successful");
    }

    @GetMapping("/cancel")
    public ResponseEntity<String> cancel() {
        return ResponseEntity.ok("Payment cancelled");
    }

}
