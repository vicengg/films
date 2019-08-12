package com.vicen.films.framework.presentation.rest;

import com.vicen.films.framework.errors.ApplicationError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

public abstract class BaseController {

    @ExceptionHandler(ApplicationError.class)
    public ResponseEntity handleError(HttpServletRequest req, ApplicationError ex) {
        return new ResponseEntity(ex.getStatus());
    }

}
