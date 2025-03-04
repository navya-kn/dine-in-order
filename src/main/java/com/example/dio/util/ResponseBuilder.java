package com.example.dio.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ResponseBuilder {
    public static <T> ResponseEntity<ResponseStructure<T>> success(HttpStatus status, String message, T data) {
        ResponseStructure<T> structur = ResponseStructure.<T>builder()
                .status(status.value())
                .message(message)
                .data(data)
                .build();
        return ResponseEntity.status(status).body(structur);
    }

    public static ResponseEntity<SimpleErrorResponse> error(HttpStatus status, String message) {
        SimpleErrorResponse error = SimpleErrorResponse.builder()
                .type(status.name())
                .status(status.value())
                .message(message)


                .build();

        return ResponseEntity.status(status).body(error);
    }

//    public static ResponseEntity<FieldErrorResponse> error(HttpStatus status, String message, List<FieldErrorResponse.FieldError> errors)
//    {
//        FieldErrorResponse error=FieldErrorResponse.builder()
//                .type(status.name())
//                .status(status.value())
//                .message(message)
//                .errors(errors)
//                .build();
//
//        return ResponseEntity.status(status)
//                .body(error);
//    }


}
