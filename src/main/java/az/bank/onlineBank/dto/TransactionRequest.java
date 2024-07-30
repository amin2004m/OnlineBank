package az.bank.onlineBank.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonPropertyOrder("transactionId,amount,type,user_id,account_id")
public class TransactionRequest {
    Long transactionsId;
    BigDecimal amount;
    String type;
    Long userId;
    Long accountId;

}
