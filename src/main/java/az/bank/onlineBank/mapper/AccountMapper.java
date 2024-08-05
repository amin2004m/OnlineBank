package az.bank.onlineBank.mapper;

import az.bank.onlineBank.dto.AccountRequest;
import az.bank.onlineBank.dto.AccountResponse;
import az.bank.onlineBank.entities.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class AccountMapper {

    public Account mapToAccountEntity(AccountRequest accountRequest){

        return Account.builder()
                .id(accountRequest.getId())
                .balance(accountRequest.getBalance())
                .build();

    }
    public static AccountResponse mapToAccountResponse(Account account){
        return AccountResponse.builder()
                .id(account.getId())
                .userId(account.getUser().getUserID())
                .balance(account.getBalance())
                .build();
    }
}
