package com.vicen.films.framework.presentation.rest

import com.vicen.films.framework.errors.ApplicationError
import com.vicen.films.framework.errors.BadRequestError
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletRequest

abstract class BaseController {

    @ExceptionHandler(ApplicationError::class)
    fun handleError(req: HttpServletRequest, ex: ApplicationError) = ResponseEntity<Any>(ex.status)

    protected fun <T> throwMandatoryFieldError(fieldName : String) : T {
        throw BadRequestError("Field $fieldName is mandatory.")
    }

}