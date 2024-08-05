package az.bank.onlineBank.services;

import az.bank.onlineBank.dto.AccountRequest;
import az.bank.onlineBank.dto.AccountResponse;
import az.bank.onlineBank.entities.Account;
import az.bank.onlineBank.exception.ServiceException;
import az.bank.onlineBank.exceptionEnum.ErrorEnum;
import az.bank.onlineBank.mapper.AccountMapper;
import az.bank.onlineBank.repositories.AccountRepository;
import az.bank.onlineBank.repositories.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AccountService {

    AccountRepository accountRepository;
    UserRepository userRepository;
    AccountMapper accountMapper;

    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> ServiceException.of(ErrorEnum.USER_NOT_FOUND));
    }

    public AccountResponse createAccount(Long userId, AccountRequest accountRequest) {

        var user = userRepository.findById(userId).orElseThrow(() ->
                ServiceException.of(ErrorEnum.ACCOUNT_CANNOT_CREATE));

        var newAccount = accountMapper.mapToAccountEntity(accountRequest);
        newAccount.setId(userId);
        newAccount.setUser(user);
        accountRepository.save(newAccount);
        return AccountMapper.mapToAccountResponse(newAccount);

    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    /////////////////////////////////


    protected void saveAccountsAll(Set<Account> accounts){
        accountRepository.saveAll(accounts);
    }

    public Set<AccountResponse> getAllAccountResponse(){

        List<Account> accounts = accountRepository.getAccounts();
        Set<AccountResponse> collect = accounts.stream().map(AccountMapper::mapToAccountResponse).collect(Collectors.toSet());
        return collect;
    }


}