package net.prateekdazz.employeeservice.exception;

import net.prateekdazz.employeeservice.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {
@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<ErrorResponseDto>handleRespourceNotFoundException(ResourceNotFoundException exception,
                                                                        WebRequest webRequest)

{

    ErrorResponseDto errorResponseDto = new ErrorResponseDto(LocalDateTime.now(), exception.getMessage(), webRequest.getDescription(false), "USER_NOT_FOUND"
    );
    return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
}

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto>handleUserAlreadyExistsException(UserAlreadyExistsException exception,
                                                                            WebRequest webRequest)

    {

        ErrorResponseDto errorResponseDto = new ErrorResponseDto(LocalDateTime.now(), exception.getMessage(), webRequest.getDescription(false), "USER_ALREADY_EXISTS"
        );
        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }


}
