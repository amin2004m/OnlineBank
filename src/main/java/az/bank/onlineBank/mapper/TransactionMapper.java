package az.bank.onlineBank.mapper;

import az.bank.onlineBank.dto.TransactionRequest;
import az.bank.onlineBank.dto.TransactionResponse;
import az.bank.onlineBank.entities.Account;
import az.bank.onlineBank.entities.Transactions;

public class TransactionMapper {

   public static Transactions mapToTransactionEntity(TransactionRequest transactionRequest){

       Account account = new Account();

       Transactions transactions =Transactions.builder()
               .transactionsId(transactionRequest.getTransactionsId())
               .type(transactionRequest.getType())
               .amount(transactionRequest.getAmount())
               .account(account)
               .build();
       return transactions;
   }

   public static TransactionResponse mapToTransactionResponse(Transactions transactions){
       return TransactionResponse.builder()
               .transactionsId(transactions.getTransactionsId())
               .type(transactions.getType())
               .amount(transactions.getAmount())
               .build();
   }
}
