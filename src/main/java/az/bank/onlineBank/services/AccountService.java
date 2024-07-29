package az.bank.onlineBank.services;

import az.bank.onlineBank.dto.AccountDto;
import az.bank.onlineBank.entities.Account;
import az.bank.onlineBank.entities.User;
import az.bank.onlineBank.mapper.AccountMapper;
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

    public Account createAccount(Long userId,AccountDto accountDto) {

        User user = userRepository
                .findById(userId).
                orElseThrow(() -> new RuntimeException("User not found!"));

        Account newAccount = AccountMapper.AccountToAccountDT(accountDto);
        return accountRepository.save(newAccount);

//        account.setUser(user);
//        Account savedAccount = accountRepository.save(account);
//        List<Account> accountList = user.getAccount();
//        accountList.add(savedAccount);
//        user.setAccount(accountList);
//        userRepository.save(user);
//
//        return account;
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }


}