package com.yousha.web;

import com.yousha.dto.TransactionDto;
import com.yousha.model.Transaction;
import com.yousha.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions")
    public List<Transaction> getAllTransactions(){
        return transactionService.findAll();
    }

    @PostMapping("/transactions")
    public Transaction createTransaction(@RequestBody @Valid TransactionDto transactionDto){
        return transactionService.create(transactionDto.getAmount(), transactionDto.getReference());
    }
}
