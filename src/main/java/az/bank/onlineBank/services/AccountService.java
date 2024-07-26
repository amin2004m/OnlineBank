package az.bank.onlineBank.services;

import az.bank.onlineBank.entities.Account;
import az.bank.onlineBank.entities.User;
import az.bank.onlineBank.repositories.AccountRepository;
import az.bank.onlineBank.repositories.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AccountService {

    AccountRepository accountRepository;
    UserRepository userRepository;

    public Account getAccountById(Long id) {
        return accountRepository.getById(id);
    }

    public Account createAccount(Account account, Long userId) {
        User user = userRepository
                .findById(userId).
                orElseThrow(() -> new RuntimeException("User not found!"));

        account.setUser(user);
        Account savedAccount = accountRepository.save(account);
        user.setAccount((List<Account>) savedAccount);
        userRepository.save(user);

        return account;
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }


}