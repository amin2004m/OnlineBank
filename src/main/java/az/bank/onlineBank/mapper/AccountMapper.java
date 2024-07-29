package az.bank.onlineBank.mapper;

import az.bank.onlineBank.dto.AccountDto;
import az.bank.onlineBank.dto.UserDto;
import az.bank.onlineBank.entities.Account;

public class AccountMapper {

    public static Account AccountToAccountDT (AccountDto accountDto){
        Account account = new Account();
        account.setId(accountDto.getId());
        account.setBalance(accountDto.getBalance());
        return account;
    }
}
