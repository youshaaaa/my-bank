package com.yousha.web;

import com.yousha.service.TransactionService;
import com.yousha.web.forms.TransactionForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class WebsiteController {

    private final TransactionService transactionService;

    public WebsiteController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @GetMapping("/account/{userId}")
    public String getAllTransactionsForAccount(Model model, @PathVariable("userId") String userId){
        model.addAttribute("userId",userId);
        model.addAttribute("transactions", transactionService.findTransactionsByUser(userId));
        model.addAttribute("transactionForm", new TransactionForm());
        return "account.html";
    }

    @PostMapping("/account/{userId}")
    public String createTransactionsForAccount(@ModelAttribute @Valid TransactionForm form, BindingResult bindingResult, Model model, @PathVariable("userId") String userId) {
        model.addAttribute("userId",userId);
        model.addAttribute("transactions", transactionService.findTransactionsByUser(userId));
        if (bindingResult.hasErrors()) {
            model.addAttribute("transactionError", true);
            return "account.html";
        }
        transactionService.create(form.getAmount(),form.getReference(),form.getUserId());
        return "redirect:/account/"+userId;
    }

}
