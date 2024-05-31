package az.bank.OnlineBank.services;

import az.bank.OnlineBank.entities.Transactions;
import az.bank.OnlineBank.repositories.TransactionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class TransactionsService {
    TransactionRepository transactionRepository;
     AccountService accountService;
    public double checkBalance(Long accountId) {
        return accountService.getAccountById(accountId).getBalance();
    }

    public Transactions withdraw(Long accountId, double amount) {
        double currentBalance = accountService.getAccountById(accountId).getBalance();
        if (currentBalance >= amount) {
            Transactions withdraw = new Transactions();
            withdraw.setTransactionsId(accountId);
            withdraw.setAmount(-amount);
            withdraw.setType("outcome");
            transactionRepository.save(withdraw);
            return withdraw;
        } else {
            System.out.println("Transaction Failed !");
            return null;
        }
    }
    public Transactions deposit(Long accountId, double amount) {
        Transactions deposit = new Transactions();
        deposit.setTransactionsId(accountId);
        deposit.setAmount(amount);
        deposit.setType("income");
        transactionRepository.save(deposit);
        return deposit;
    }
}
