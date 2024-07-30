package az.bank.onlineBank.services;

import az.bank.onlineBank.dto.AccountRequest;
import az.bank.onlineBank.entities.Account;
import az.bank.onlineBank.mapper.AccountMapper;
import az.bank.onlineBank.repositories.AccountRepository;
import az.bank.onlineBank.repositories.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AccountService {

    AccountRepository accountRepository;

    public Account getAccountById(Long id) {
        return accountRepository.getById(id);
    }

    public Account createAccount(Long userId, AccountRequest accountRequest) {

//            User user = userRepository
//                    .findById(userId).
//                    orElseThrow(() -> new RuntimeException("User not found!"));

        Account newAccount = AccountMapper.mapToAccountEntity(accountRequest);
        return accountRepository.save(newAccount);


    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }


}