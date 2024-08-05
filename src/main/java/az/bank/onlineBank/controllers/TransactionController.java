package az.bank.onlineBank.controllers;

import az.bank.onlineBank.dto.TransactionResponse;
import az.bank.onlineBank.services.TransactionsService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/transactions")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TransactionController {
    TransactionsService transactionsService;

    @GetMapping("/balance/{accountId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> checkBalance(@PathVariable Long accountId) {
        return ResponseEntity
                .ok(transactionsService.checkBalance(accountId));
    }

    @PostMapping("/withdraw/{accountId}")
    @ResponseStatus(HttpStatus.OK)
    public TransactionResponse withdraw(@PathVariable Long accountId, @RequestParam BigDecimal amount) {
        return transactionsService.withdraw(accountId, amount);
    }

    @PostMapping("/deposit/{accountId}")
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal deposit(@PathVariable Long accountId,
                              @RequestParam BigDecimal amount,
                              @RequestParam(required = false) BigDecimal balance) {

        return transactionsService.deposit(accountId, amount, balance);
    }

}
