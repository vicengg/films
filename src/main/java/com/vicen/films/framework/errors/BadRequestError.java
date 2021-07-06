package com.vicen.films.framework.errors;

import org.springframework.http.HttpStatus;

public class BadRequestError extends ApplicationError {

    public BadRequestError(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
