package com.example.controller;

import com.example.model.StripeRequest;
import com.example.model.StripeResponse;
import com.example.service.StripeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class CheckoutController {

    private final StripeService stripeService;

    @PostMapping("/checkout")
    public ResponseEntity<StripeResponse> checkout(@RequestBody List<StripeRequest> stripeRequests) {

        StripeResponse stripeResponse = stripeService.checkout(stripeRequests);
        return "SUCCESS".equals(stripeResponse.getStatus()) ? ResponseEntity.ok(stripeResponse) : ResponseEntity.badRequest().body(stripeResponse);

    }

    @GetMapping("/success")
    public ResponseEntity<String> success(@RequestParam String paymentId) {
        return ResponseEntity.ok("Payment successful for payment " + paymentId);
    }

    @GetMapping("/cancel")
    public ResponseEntity<String> cancel(@RequestParam String paymentId) {
        return ResponseEntity.ok("Payment cancelled for payment " + paymentId);
    }

}
