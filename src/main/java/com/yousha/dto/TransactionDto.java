package com.yousha.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TransactionDto {

    @NotBlank @NotNull(message = "Please enter reference")
    private String reference;
    @DecimalMax("1000.5")
    @DecimalMin("0.5")
    @NotNull(message = "Please enter amount")
    private Double amount;

    @NotNull @NotBlank
    private String userId;

    public String getReference() {
        return reference;
    }

    public Double getAmount() {
        return amount;
    }

    public String getUserId() {
        return userId;
    }
}
