package com.awesomeorg.restaurantservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class NotFoundException extends ResponseStatusException {
    public NotFoundException(final String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
