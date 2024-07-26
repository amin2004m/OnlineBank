package az.bank.onlineBank.exceptionEnum;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum ErrorEnum {

    USER_ALREADY_EXCEPTION(46, "User already exist !"),
    USER_NOT_FOUND(404, "User not found !");

    int errorCode;
    String errorMessage;


}
