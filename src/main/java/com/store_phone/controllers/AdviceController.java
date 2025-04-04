package com.store_phone.controllers;

import com.store_phone.exception.BadRequestException;
import com.store_phone.exception.UnprocessableException;
import com.store_phone.response.BaseResponse;
import com.store_phone.utils.PasswordUtils;
import jdk.jshell.spi.ExecutionControl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviceController {

    private final Logger logger = LoggerFactory.getLogger(AdviceController.class);

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<BaseResponse> handleThrowable(Throwable exception) {
        BaseResponse result = new BaseResponse();
        logger.error(exception.toString(), exception);
        result.setCode(HttpStatus.INTERNAL_SERVER_ERROR.name());
        result.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BaseResponse> handleBadRequest(BadRequestException exception){
        BaseResponse result = new BaseResponse();
        result.setCode(exception.getErrorCode());
        result.setMessage(exception.getErrorMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException exception){
        BaseResponse result = new BaseResponse();
        result.setCode(exception.getFieldError().getField());
        result.setMessage(exception.getFieldError().getDefaultMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    @ExceptionHandler(UnprocessableException.class)
    public ResponseEntity<BaseResponse> handleUnprocessableException(UnprocessableException exception){
        BaseResponse result = new BaseResponse();
        result.setCode(exception.getErrorCode());
        result.setMessage(exception.getErrorMessage());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(result);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<BaseResponse> handleUsernameNotFoundException (UsernameNotFoundException exception) {
        BaseResponse result = new BaseResponse();
        result.setCode(HttpStatus.UNAUTHORIZED.name());
        result.setMessage(exception.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
    }

    @ExceptionHandler(AuthorizationDeniedException.class)
    public ResponseEntity<BaseResponse> handleAccessDeniedException (AuthorizationDeniedException exception) {
        BaseResponse result = new BaseResponse();
        result.setCode(HttpStatus.UNAUTHORIZED.name());
        result.setMessage(exception.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
    }

}
