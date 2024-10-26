package com.user.User.MicroService.exception;

import com.user.User.MicroService.dto.ApiResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponseDto> handlerResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        String message = ex.getMessage();

        ApiResponseDto apiResponseDto = new ApiResponseDto(request.getDescription(false), HttpStatus.BAD_REQUEST,ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(apiResponseDto,HttpStatus.BAD_REQUEST);

    }
}
