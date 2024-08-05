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
    USER_NOT_FOUND(404, "User not found !"),
    PAN_NOT_CREATED(404,"Pan should not be empty"),
    ERROR_CREATING_USER(404,"User cannot create !"),
    ACCOUNT_CANNOT_CREATE(404,"Account cannot create !");

    int errorCode;
    String errorMessage;


}
