package az.bank.onlineBank.exception;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ErrorResponse {

    String uuid;
    int errorCode;
    String errorMessage;
    List<FieldErrors> fieldErrors;

}
