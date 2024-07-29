package az.bank.onlineBank.services;

import az.bank.onlineBank.dto.TransactionsDto;
import az.bank.onlineBank.entities.Transactions;
import az.bank.onlineBank.exception.ServiceException;
import az.bank.onlineBank.mapper.TransactionMapper;
import az.bank.onlineBank.repositories.TransactionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TransactionsService {
    TransactionRepository transactionRepository;
    AccountService accountService;

    public BigDecimal checkBalance(Long accountId, TransactionsDto transactionsDto) {
        return accountService.getAccountById(accountId).getBalance();
    }

    public Transactions withdraw(Long accountId, BigDecimal amount) {
        BigDecimal currentBalance = accountService
                .getAccountById(accountId)
                .getBalance();

        checkEnoughBalance(currentBalance, amount);

        return doTransaction(accountId, amount);

    }

    public Transactions deposit(Long accountId, BigDecimal amount) {
        Transactions deposit = new Transactions();
        deposit.setTransactionsId(accountId);
        deposit.setAmount(amount);
        deposit.setType("income");
        transactionRepository.save(deposit);
        return deposit;
    }

    private void checkEnoughBalance(BigDecimal currentBalance, BigDecimal amount) {
        if (currentBalance.compareTo(amount)<0) {
            System.out.println("Transaction Failed !");
            throw ServiceException.of(101, "Balance is not enough");
        }
    }

    private Transactions doTransaction(Long accountId, BigDecimal amount) {

        BigDecimal newAmount = amount.subtract(BigDecimal.ONE);

        Transactions withdraw = new Transactions();
        withdraw.setTransactionsId(accountId);
        withdraw.setAmount(newAmount);
        withdraw.setType("outcome");
        return transactionRepository.save(withdraw);
    }

}
