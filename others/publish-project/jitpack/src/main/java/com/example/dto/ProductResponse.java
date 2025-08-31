package com.example.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Schema(description = "Model of object ProductResponse")
public class ProductResponse {

    @Schema(description = "Status of this product response")
    private String status;

    @Schema(description = "Message of this product response")
    private String message;

    @Schema(description = "Errors related to this product response")
    private Map<String, String> errors;


    @Schema(description = "List of Products in this response")
    private String products;

}
