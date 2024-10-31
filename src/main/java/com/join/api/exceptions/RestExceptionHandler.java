package com.join.api.exceptions;

import lombok.NonNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
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
                        "Campos inválidos",
                        listFieldsResponse);

        return new ResponseEntity<>(errorResponseBody, status);
    }
}
