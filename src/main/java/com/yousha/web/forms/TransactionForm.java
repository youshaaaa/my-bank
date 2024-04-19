package com.yousha.web.forms;

import jakarta.validation.constraints.*;

public class TransactionForm {

    @NotBlank
    private String userId;

    @NotNull
    @DecimalMin("0.5")
    @Max(1000)
    private Double amount;

    @NotBlank
    @Size(min = 1, max = 25)
    private String reference;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
