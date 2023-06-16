package com.humancloud.Employeemanagementsystem.Exceptions;

import com.humancloud.Employeemanagementsystem.Helper.ApiResponce;
import com.humancloud.Employeemanagementsystem.Helper.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobleExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponce> resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {
        String message = ex.getMessage();
        ApiResponce apiResponce = new ApiResponce(message, false);
        return new ResponseEntity<ApiResponce>(apiResponce, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ApiResponce> unauthorizedExceptionHandler(UnauthorizedException ex) {
        String message = ex.getMessage();
        ApiResponce apiResponce = new ApiResponce(message, false);
        return new ResponseEntity<ApiResponce>(apiResponce, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentsNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> resp = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            resp.put(fieldName, message);
        });
        return new ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(EmailAllReadyExitsException.class)
    public ResponseEntity<ApiResponce> EmailAllReadyExitsException(EmailAllReadyExitsException ex) {
        String message = ex.getMessage();
        ApiResponce apiResponce = new ApiResponce(message, false);
        return new ResponseEntity<ApiResponce>(apiResponce, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ApiResponce> SQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex) {
        String message = ex.getMessage();
        ApiResponce apiResponce = new ApiResponce(message, false);
        return new ResponseEntity<ApiResponce>(apiResponce, HttpStatus.BAD_REQUEST);
    }
}