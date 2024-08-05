package az.bank.onlineBank.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonPropertyOrder({"userId,username,account_id,createdAt"})
public class UserRequest {

    Long userId;
    String username;
    String password;
    Boolean isActive = true;
    Set<AccountRequest> accounts;
}
