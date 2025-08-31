package com.example.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(description = "Model of object ProductRequest")
public class ProductRequest {

    @Schema(description = "List of Products in request")
    @NotEmpty(message = "Products are mandatory")
    private String products;

}
