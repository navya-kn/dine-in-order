package com.example.dio.util;

import org.apache.logging.log4j.message.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseBuilder
{

    public static <T> ResponseEntity<ResponseStructure<T>> success(HttpStatus status, String message, T data ) {
        ResponseStructure<T> structure= ResponseStructure.<T>builder()
                .status(status.value())
                .message(message)
                .data(data)
                .build();
        return ResponseEntity.status(status)
                .body(structure);
    }
}



