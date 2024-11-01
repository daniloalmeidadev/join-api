package com.join.api.exceptions.advice;

import lombok.Getter;

import java.io.Serial;

@Getter
public class DomainException extends RuntimeException  {

    @Serial
    private static final long serialVersionUID = 1L;

    private final String message;

    public DomainException(String message) {
        super();
        this.message = message;
    }
}
