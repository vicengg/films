package com.vicen.films.framework.errors;

import org.springframework.http.HttpStatus;

public class NotFoundError extends ApplicationError {

    public NotFoundError() {
        super();
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
