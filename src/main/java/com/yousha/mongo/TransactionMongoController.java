package com.yousha.mongo;

import com.yousha.dto.TransactionDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mongotest")
public class TransactionMongoController {

    private final TransactionMongoService transactionMongoService;

    public TransactionMongoController(TransactionMongoService transactionMongoService){
        this.transactionMongoService = transactionMongoService;
    }

    @GetMapping("/transactions")
    public List<Transaction> getAllTransactions(){
        return transactionMongoService.getAllTransactions();
    }

    @PostMapping("/transactions")
    public Transaction createTransaction(@RequestBody @Valid TransactionDto transactionDto){
        return transactionMongoService.saveTransaction(transactionDto.getAmount(), transactionDto.getReference());
    }
}
