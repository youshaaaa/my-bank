package com.yousha.web;

import com.yousha.dto.TransactionDto;
import com.yousha.model.Transaction;
import com.yousha.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class ThymeleafController {

    private final TransactionService transactionService;

    public ThymeleafController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @GetMapping("/account/{userId}")
    public String getAllTransactionsForAccount(){
        return "transactions.html";
    }

    @GetMapping("/account")
    public String x(){
        return "x.html";
    }

}
