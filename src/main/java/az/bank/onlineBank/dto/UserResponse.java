package az.bank.onlineBank.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserResponse {
    Long id;
    String username;
    String password;
    LocalDateTime createdAt;
}
