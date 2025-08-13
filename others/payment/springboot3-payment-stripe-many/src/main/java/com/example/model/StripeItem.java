package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StripeItem {
    private Long amount;
    private Long quantity;
    private String name;
    private String currency;
}
