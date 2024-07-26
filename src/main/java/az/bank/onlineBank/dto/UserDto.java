package az.bank.onlineBank.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonPropertyOrder({"userId,username,account_id,createdAt"})
public class UserDto {

    Long userId;
    String username;
    Long account_id;
    LocalDateTime createdAt;
}
