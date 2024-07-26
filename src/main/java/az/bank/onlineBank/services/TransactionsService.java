package az.bank.onlineBank.services;

import az.bank.onlineBank.entities.Transactions;
import az.bank.onlineBank.exception.ServiceException;
import az.bank.onlineBank.repositories.TransactionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TransactionsService {
    TransactionRepository transactionRepository;
    AccountService accountService;

    public double checkBalance(Long accountId) {
        return accountService.getAccountById(accountId).getBalance();
    }

    public Transactions withdraw(Long accountId, double amount) {
        double currentBalance = accountService
                .getAccountById(accountId)
                .getBalance();

        checkEnoughBalance(currentBalance, amount);

        return doTransaction(accountId, amount);

    }

    public Transactions deposit(Long accountId, double amount) {
        Transactions deposit = new Transactions();
        deposit.setTransactionsId(accountId);
        deposit.setAmount(amount);
        deposit.setType("income");
        transactionRepository.save(deposit);
        return deposit;
    }

    private void checkEnoughBalance(double currentBalance, double amount) {
        if (currentBalance < amount) {
            System.out.println("Transaction Failed !");
            throw ServiceException.of(101, "Balance is not enough");
        }
    }

    private Transactions doTransaction(Long accountId, double amount) {
        Transactions withdraw = new Transactions();
        withdraw.setTransactionsId(accountId);
        withdraw.setAmount(-amount);
        withdraw.setType("outcome");
        return transactionRepository.save(withdraw);
    }

}
