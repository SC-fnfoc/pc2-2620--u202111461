package com.aquamonitor.platform.u202111461.shared.interfaces.rest;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.aquamonitor.platform.u202111461.shared.interfaces.rest.resources.MessageResource;

@RestControllerAdvice 
public class GlobalExceptionHandler {
   private final MessageSource messageSource;

    public GlobalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * Handles malformed JSON payloads or invalid field formats.
     *
     * @param ex the caught {@link HttpMessageNotReadableException}
     * @return HTTP 400 response with localized error message
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<MessageResource> handleUnreadableMessage(HttpMessageNotReadableException ex) {
        String msg = messageSource.getMessage("validation.request.malformed", null, LocaleContextHolder.getLocale());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResource(msg));
    }

    /**
     * Fallback handler for any unexpected internal server errors.
     *
     * @param ex the unexpected exception
     * @return HTTP 500 response with localized error message
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MessageResource> handleUnexpectedException(Exception ex) {
        String msg = messageSource.getMessage("error.internal", null, LocaleContextHolder.getLocale());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResource(msg));
    }
}  
    