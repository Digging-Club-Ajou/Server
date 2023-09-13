package server.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import server.global.constant.StatusCodeConstant;
import server.global.exception.dto.ExceptionResponse;
import server.global.exception.dto.MethodArgumentExceptionResponse;

import java.util.concurrent.ConcurrentHashMap;

@RestControllerAdvice
public class ApiRestControllerAdvice {

    // 400
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public MethodArgumentExceptionResponse methodArgumentNotValidException(
            final MethodArgumentNotValidException e
    ) {
        MethodArgumentExceptionResponse exceptionResponse = new MethodArgumentExceptionResponse(
                        StatusCodeConstant.BAD_REQUEST.statusCode,
                        new ConcurrentHashMap<>()
                );

        e.getFieldErrors().forEach(exceptionResponse::addValidation);
        return exceptionResponse;
    }

    // 400
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public ExceptionResponse handleException(final BadRequestException e) {
        return new ExceptionResponse(e.getStatusCode(), e.getMessage());
    }

    // 401
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnAuthorizedException.class)
    public ExceptionResponse handleException(final UnAuthorizedException e) {
        return new ExceptionResponse(e.getStatusCode(), e.getMessage());
    }

    // 404
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ExceptionResponse handleException(final NotFoundException e) {
        return new ExceptionResponse(e.getStatusCode(), e.getMessage());
    }
}
