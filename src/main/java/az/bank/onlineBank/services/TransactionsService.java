package az.bank.onlineBank.services;

import az.bank.onlineBank.dto.TransactionResponse;
import az.bank.onlineBank.entities.Transactions;
import az.bank.onlineBank.exception.ServiceException;
import az.bank.onlineBank.repositories.TransactionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static az.bank.onlineBank.mapper.TransactionMapper.mapToTransactionResponse;


@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TransactionsService {

    TransactionRepository transactionRepository;
    AccountService accountService;

    public BigDecimal checkBalance(Long accountId) {
        return accountService.getAccountById(accountId).getBalance();
    }

    public TransactionResponse withdraw(Long accountId, BigDecimal amount) {
        BigDecimal currentBalance = accountService
                .getAccountById(accountId)
                .getBalance();

        checkEnoughBalance(currentBalance, amount);

        return doTransaction(accountId, amount);

    }

    public BigDecimal deposit(Long accountId, BigDecimal amount,BigDecimal balance) {
        Transactions deposit = new Transactions();
        deposit.setTransactionsId(accountId);
        deposit.setAmount(amount);
        deposit.setType("income");
        Transactions savedTransaction = transactionRepository.save(deposit);

        return totalBalance(amount,balance);
//         mapToTransactionResponse(savedTransaction);
    }

    //----------Private Methods

    private BigDecimal totalBalance(BigDecimal amount,BigDecimal balance){
        BigDecimal total = balance.add(amount);
        return total;
    }

    private void checkEnoughBalance(BigDecimal currentBalance, BigDecimal amount) {
        if (currentBalance.compareTo(amount) < 0) {
            System.out.println("Transaction Failed !");
            throw ServiceException.of(101, "Balance is not enough");
        }
    }

    private TransactionResponse doTransaction(Long accountId, BigDecimal amount) {

        BigDecimal newAmount = amount.subtract(BigDecimal.ONE);

        Transactions withdraw = new Transactions();
        withdraw.setTransactionsId(accountId);
        withdraw.setAmount(newAmount);
        withdraw.setType("outcome");
        return mapToTransactionResponse(transactionRepository.save(withdraw));
    }

}
