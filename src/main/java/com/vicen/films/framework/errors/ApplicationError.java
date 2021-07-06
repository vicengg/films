package com.vicen.films.framework.errors;

import org.springframework.http.HttpStatus;

public abstract class ApplicationError extends RuntimeException {

    public ApplicationError() {
        super();
    }

    public ApplicationError(String message) {
        super(message);
    }

    public ApplicationError(Throwable cause) {
        super(cause.getMessage(), cause);
    }

    public abstract HttpStatus getStatus();

}
