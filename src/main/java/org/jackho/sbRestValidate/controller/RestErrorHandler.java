package org.jackho.sbRestValidate.controller;

import org.jackho.sbRestValidate.dto.ValidationErrorDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Petri Kainulainen
 */
/*
 * Classes annotated with @ControllerAdvice can contain @ExceptionHandler, @InitBinder, 
 * and @ModelAttribute methods and those will apply to @RequestMapping methods across controller 
 * hierarchies as opposed to the controller hierarchy within which they are declared. @ControllerAdvice
 * is a component annotation allowing implementation classes to be auto-detected through classpath scanning.
 * */

@ControllerAdvice
public class RestErrorHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestErrorHandler.class);
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ValidationErrorDTO processValidationError(MethodArgumentNotValidException ex,HttpServletResponse response ) {
        LOGGER.debug("Handling form validation error");

        BindingResult result = ex.getBindingResult();
        // 1. get a list fieldError objects and process them
        List<FieldError> fieldErrors = result.getFieldErrors();
        
        ValidationErrorDTO dto = new ValidationErrorDTO();
        
        for(FieldError fieldError: fieldErrors){
        	dto.addFieldError(fieldError.getField(), fieldError.getDefaultMessage());
        }
        response.setHeader("X-Status-Reason","Validation failed");

        return dto;
    }
}
