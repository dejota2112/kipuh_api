package com.nastypad.kipuhapi.shared.exception;

import jakarta.validation.ConstraintViolation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Set;
import java.util.stream.Collectors;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResourceValidationException extends RuntimeException {
    public ResourceValidationException() {
    }

    public ResourceValidationException(String message) {
        super(message);
    }

    public <T> ResourceValidationException(String entity, Set<ConstraintViolation<T>> violations) {
        super(String.format("Not all constraint satisfied for %s: %s", entity,
                violations.stream().map(
                        violation -> String.format("%s %s", violation.getPropertyPath(), violation.getMessage())).collect(Collectors.joining(", "))));
    }

}
