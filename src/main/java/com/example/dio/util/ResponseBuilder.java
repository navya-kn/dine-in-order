package com.example.dio.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ResponseBuilder {
    /**
     * helps creating the success response with data including the http status code,message and data itself
     * @param status status of the operation performed
     * @param message message to the user
     * @param data involved in the operation
     * @return response entity of the type response structure or type T(the involved int operation)

     */

    public static <T> ResponseEntity<ResponseStructure<T>> success(HttpStatus status, String message, T data) {
        ResponseStructure<T> structure = ResponseStructure.<T>builder()
                .status(status.value())
                .message(message)
                .data(data)
                .build();
        return ResponseEntity.status(status).body(structure);
    }

    /**
     *
     * @param message message to the user
     * @param data involved in the operation
     * @return response entity of the type response structure or type T(the involved int operation)


     */

    public static <T> ResponseEntity<ResponseStructure<T>> ok(String message,T data)
    {
        return success(HttpStatus.OK,message,data);
    }

    /**
     *
     * @param message message to the user
     * @param data data involved in the operation
     * @return response entity of response structure or type T
     * @param <T>
     */

    public static <T> ResponseEntity<ResponseStructure<T>> created(String message,T data)
    {
        return success(HttpStatus.CREATED,message,data);
    }

    /**
     * helps creating the error response with the data including http status code and message
     * @param status status of the operation performed
     * @param message message to the user
     * @return response entity of response structure
     */

    public static ResponseEntity<SimpleErrorResponse> error(HttpStatus status, String message) {
        SimpleErrorResponse error = SimpleErrorResponse.builder()
                .type(status.name())
                .status(status.value())
                .message(message)


                .build();

        return ResponseEntity.status(status).body(error);
    }

    /**
     *
     * @param message message to the user
     * @return response Entity of response structure
     */


    public static ResponseEntity<SimpleErrorResponse> notfound( String message) {

        return error(HttpStatus.NOT_FOUND, message);
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
