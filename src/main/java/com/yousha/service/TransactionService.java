package com.yousha.service;

import com.yousha.model.Transaction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class TransactionService {

    private final String bankSlogan;

    List<Transaction> transactions = new CopyOnWriteArrayList<>();

    public TransactionService(@Value("${bank.slogan}") String bankSlogan) {
        this.bankSlogan = bankSlogan;
    }

    public List<Transaction> findAll(){
        return transactions;
    }

    //can be done through spring data JPA rather than stream
    public List<Transaction> findTransactionsByUser(String userId){
        return transactions.stream().filter(x -> x.getUserId().equals(userId)).toList();
    }

    public Transaction create(Double amount, String reference, String userId){
        ZonedDateTime time = ZonedDateTime.now();
        Transaction transaction = new Transaction(amount,reference, time, bankSlogan, userId);
        transactions.add(transaction);
        return transaction;
    }
}
