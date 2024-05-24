package az.bank.OnlineBank.controllers;

import az.bank.OnlineBank.entities.Transactions;
import az.bank.OnlineBank.services.TransactionsService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TransactionController {
    TransactionsService transactionsService;

    @GetMapping("/balance/{accountId}")
    public double checkBalance(@PathVariable Long accountId) {
        return transactionsService.checkBalance(accountId);
    }

    @PostMapping("/withdraw/{accountId}")
    public Transactions withdraw(@PathVariable Long accountId, @RequestParam double amount) {
        return transactionsService.withdraw(accountId, amount);
    }

    @PostMapping("/deposit/{accountId}")
    public Transactions deposit(@PathVariable Long accountId, @RequestParam double amount) {
        return transactionsService.deposit(accountId, amount);
    }
}
