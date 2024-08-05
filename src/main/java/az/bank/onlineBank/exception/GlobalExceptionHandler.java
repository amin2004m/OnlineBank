package az.bank.onlineBank.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(500);
        errorResponse.setErrorMessage(exception.getMessage());
        errorResponse.setUuid(UUID.randomUUID().toString());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ErrorResponse> handleServiceException(ServiceException exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(404);
        errorResponse.setErrorMessage(exception.getMessage());
        errorResponse.setUuid(UUID.randomUUID().toString());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<FieldErrors> fieldErrors = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(fieldError -> new FieldErrors(fieldError.getField(), fieldError.getDefaultMessage()))
                .collect(Collectors.toList());

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(400);
        errorResponse.setErrorMessage("Validation Failed");
        errorResponse.setUuid(UUID.randomUUID().toString());
        errorResponse.setFieldErrors(fieldErrors);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException ex) {
        List<FieldErrors> fieldErrors = ex.getConstraintViolations().stream()
                .map(this::mapToFieldError)
                .collect(Collectors.toList());

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(400);
        errorResponse.setErrorMessage("Constraint Violation");
        errorResponse.setUuid(UUID.randomUUID().toString());
        errorResponse.setFieldErrors(fieldErrors);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    private FieldErrors mapToFieldError(ConstraintViolation<?> violation) {
        return new FieldErrors(violation.getPropertyPath().toString(), violation.getMessage());
    }
}
