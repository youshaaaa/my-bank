package com.yousha.mongo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

@Service
public class TransactionMongoService {

    private final String bankSlogan;
    private final TransactionRepository repository;

    public TransactionMongoService(@Value("${bank.slogan}") String bankSlogan, TransactionRepository repository) {
        this.bankSlogan = bankSlogan;
        this.repository = repository;
    }

    public Transaction saveTransaction(Double amount, String reference) {
//        ZonedDateTime time = ZonedDateTime.now();
        Transaction transaction = new Transaction(amount,reference, Date.from(Instant.now()), bankSlogan);
        return repository.save(transaction);
    }
    public Transaction getTransaction(String id) {
        return repository.findById(id).orElse(null);
    }
    public List<Transaction> getAllTransactions(){
        return repository.findAll();
//        return repository.findByReference("asd");
    }
    public void deleteTransaction(String id) {
        repository.deleteById(id);
    }
}
