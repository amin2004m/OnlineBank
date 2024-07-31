package az.bank.onlineBank.services;

import az.bank.onlineBank.dto.AccountRequest;
import az.bank.onlineBank.entities.Account;
import az.bank.onlineBank.exception.ServiceException;
import az.bank.onlineBank.exceptionEnum.ErrorEnum;
import az.bank.onlineBank.mapper.AccountMapper;
import az.bank.onlineBank.repositories.AccountRepository;
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
        return accountRepository.findById(id)
                .orElseThrow(() -> ServiceException.of(ErrorEnum.USER_NOT_FOUND));
    }

    public Account createAccount(Long userId, AccountRequest accountRequest) {


        var newAccount = AccountMapper.mapToAccountEntity(accountRequest);
        return accountRepository.save(newAccount);


    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }


}