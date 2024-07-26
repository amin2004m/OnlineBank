package az.bank.onlineBank.exception;

import az.bank.onlineBank.exceptionEnum.ErrorEnum;

public class ServiceException extends RuntimeException {

    public  ServiceException(int code, String errorMessage) {
        super(errorMessage);
    }

    public static ServiceException of(int code, String errorMessage) {
        return new ServiceException(code, errorMessage);
    }

    public static ServiceException of(ErrorEnum errorEnum) {
        return new ServiceException(
                errorEnum.getErrorCode(),
                errorEnum.getErrorMessage());
    }

}
