package com.epam.lab.spring.khokhliatskii.evernote.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ValidationException;

/**
 * Class for handling exceptions
 */
@ControllerAdvice
public class ControllerExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(ValidationException.class)
    public String handleValidationException(Exception e, Model model) {
        LOGGER.error("Validation exception, {}", e);
        model.addAttribute("message", HttpStatus.UNPROCESSABLE_ENTITY.toString());
        return "error";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException(Exception e, Model model) {
        LOGGER.error("Illegal argument exception, {}", e);
        model.addAttribute("message", HttpStatus.BAD_REQUEST.toString());
        return "error";
    }

    @ExceptionHandler(NullPointerException.class)
    public String handleNullPointerException(Exception e, Model model) {
        LOGGER.error("Null pointer exception, {}", e);
        model.addAttribute("message", HttpStatus.BAD_REQUEST.toString());
        return "error";
    }

    @ExceptionHandler(IllegalStateException.class)
    public String handleIllegalStateException(Exception e, Model model) {
        LOGGER.error("Illegal state exception, {}", e);
        model.addAttribute("message", HttpStatus.NO_CONTENT.toString());
        return "error";
    }

    @ExceptionHandler(RuntimeException.class)
    public String handleRuntimeException(Exception e, Model model) {
        LOGGER.error("Application runtime exception, {}", e);
        model.addAttribute("message", HttpStatus.INTERNAL_SERVER_ERROR.toString());
        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {
        LOGGER.error("Application exception, {}", e);
        model.addAttribute("message", HttpStatus.INTERNAL_SERVER_ERROR.toString());
        return "error";
    }
}
