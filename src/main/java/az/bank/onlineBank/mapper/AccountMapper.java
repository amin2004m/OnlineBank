package az.bank.onlineBank.mapper;

import az.bank.onlineBank.dto.AccountRequest;
import az.bank.onlineBank.dto.AccountResponse;
import az.bank.onlineBank.entities.Account;

public class AccountMapper {

    public static Account mapToAccountEntity(AccountRequest accountRequest){

        Account account = Account.builder()
                .id(accountRequest.getId())
                .balance(accountRequest.getBalance())
                .build();
        return account;
    }
    public static AccountResponse mapToAccountResponse(Account account){
        return AccountResponse.builder()
                .id(account.getId())
                .userId(account.getUser().getUserID())
                .balance(account.getBalance())
                .build();
    }
}
