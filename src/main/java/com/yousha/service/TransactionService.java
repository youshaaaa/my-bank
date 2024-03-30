package com.yousha.service;

import com.yousha.model.Transaction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

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
//    public Transaction findById(String id){
//        List<Transaction> ts = transactions.stream().filter(transaction -> transaction.getId().equals(id)).collect(Collectors.toList());
//        if(!ts.isEmpty()){
//            return ts.get(0);
//        }
//        return null;
//    }

    public Transaction create(Double amount, String reference){
        ZonedDateTime time = ZonedDateTime.now();
        Transaction transaction = new Transaction(amount,reference, time, bankSlogan);
        transactions.add(transaction);
        return transaction;
    }
}
