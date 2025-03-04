package com.example.dio.util;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import java.util.List;

@Getter
@SuperBuilder
public class FieldErrorResponse extends SimpleErrorResponse {
    private List<CustomFieldError> errors;

    public static CustomFieldError createFieldError( String message, Object rejectedValue,String field) {
        CustomFieldError error = new CustomFieldError();
        error.message = message;
        error.rejectedValue = rejectedValue;
        error.field = field;
        return  error;

    }

    @Getter
    public static class CustomFieldError {
        private String message;
        private Object rejectedValue;
        private String field;


    }

}
