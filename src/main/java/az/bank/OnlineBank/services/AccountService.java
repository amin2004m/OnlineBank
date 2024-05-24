package az.bank.OnlineBank.services;

import az.bank.OnlineBank.entities.Account;
import az.bank.OnlineBank.repositories.AccountRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class AccountService {

    AccountRepository accountRepository;


    public Account getAccountById(Long id) {
        return accountRepository.getById(id);
    }



}