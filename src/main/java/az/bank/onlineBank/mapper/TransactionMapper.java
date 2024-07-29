package az.bank.onlineBank.mapper;

import az.bank.onlineBank.dto.TransactionsDto;
import az.bank.onlineBank.entities.Transactions;

public class TransactionMapper {

    public static Transactions transactionsToDto(TransactionsDto transactionsDto){
        Transactions transactions = new Transactions();
        transactions.setTransactionsId(transactionsDto.getTransactionsId());
        transactions.setAmount(transactionsDto.getAmount());
        transactions.setType(transactionsDto.getType());
        return transactions;

    }
}
