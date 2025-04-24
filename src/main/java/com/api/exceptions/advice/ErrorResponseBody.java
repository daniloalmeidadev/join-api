package com.api.exceptions.advice;

import lombok.Getter;
import org.springframework.http.HttpStatusCode;

import java.util.List;

@Getter
public class ErrorResponseBody {

    private final int status;

    private final String message;

    private final List<Fields> fields;

    public ErrorResponseBody(HttpStatusCode status, String message) {
        this.status = status.value();
        this.message = message;
        this.fields = null;
    }

    public ErrorResponseBody(HttpStatusCode status, String message, List<Fields> Fields) {
        this.status = status.value();
        this.message = message;
        this.fields = Fields;
    }
}
