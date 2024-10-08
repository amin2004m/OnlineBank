package az.bank.onlineBank.controllers;

import az.bank.onlineBank.dto.AccountRequest;
import az.bank.onlineBank.dto.AccountResponse;
import az.bank.onlineBank.services.AccountService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/accounts")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AccountController {

    AccountService accountService;

    @PostMapping("/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountResponse createAccount(@RequestBody AccountRequest account,
                                         @PathVariable Long userId) {
        return accountService.createAccount(userId, account);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccountById(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }

    @GetMapping
    public Set<AccountResponse> getAllAccounts() {
        return accountService.getAllAccountResponse();
    }

}
