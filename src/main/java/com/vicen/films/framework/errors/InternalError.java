package com.vicen.films.framework.errors;

import org.springframework.http.HttpStatus;

public class InternalError extends ApplicationError {

    public InternalError(Throwable cause) {
        super(cause);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

}
