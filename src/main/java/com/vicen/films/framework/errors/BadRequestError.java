package com.vicen.films.framework.errors;

import org.springframework.http.HttpStatus;

public class BadRequestError extends ApplicationError {

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
