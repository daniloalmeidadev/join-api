package com.join.api.exceptions.advice;

import lombok.NonNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            @NonNull MethodArgumentNotValidException ex,
            @NonNull HttpHeaders headers,
            @NonNull HttpStatusCode status,
            @NonNull WebRequest request) {

        List<Fields> listFieldsResponse = new ArrayList<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {

            Fields fields = new Fields();

            fields.setField(error.getField());
            fields.setMessage(error.getDefaultMessage());

            listFieldsResponse.add(fields);
        });

        ErrorResponseBody errorResponseBody =
                new ErrorResponseBody(
                        status,
                        "Invalid fields",
                        listFieldsResponse);

        return new ResponseEntity<>(errorResponseBody, status);
    }

    @ExceptionHandler(DomainException.class)
    public final ResponseEntity<Object> handleDomainException(DomainException e) {

        HttpStatus status = e.getClass().getAnnotation(ResponseStatus.class).value();

        ErrorResponseBody errorResponseBody = new ErrorResponseBody(status, e.getMessage());

        return new ResponseEntity<>(errorResponseBody, status);
    }
}
