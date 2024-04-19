package com.yousha.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.ZonedDateTime;
import java.util.UUID;

public class Transaction {
//    id, an amount, a timestamp and a reference string ("eating out at mcdonalds").
//    The API should return JSON and the timestamps should be formatted nicely as

    private String id;
    private Double amount;

    private String userId;
    private String reference;
    private String bankSlogan;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mmZ")
    private ZonedDateTime time;

    public Transaction(Double amount, String reference, ZonedDateTime time, String bankSlogan, String userId) {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.userId = userId;
        this.reference = reference;
        this.time = time;
        this.bankSlogan = bankSlogan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public void setTime(ZonedDateTime time) {
        this.time = time;
    }

    public String getBankSlogan() {
        return bankSlogan;
    }

    public void setBankSlogan(String bankSlogan) {
        this.bankSlogan = bankSlogan;
    }
}
