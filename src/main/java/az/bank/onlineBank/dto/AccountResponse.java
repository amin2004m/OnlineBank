package az.bank.onlineBank.dto;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class AccountResponse {

    Long id;
    Long userId;
    BigDecimal balance;
}
