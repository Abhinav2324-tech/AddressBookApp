package com.bridgelabz.addressbookapp.dto;

/**
 * Wraps the result of a REST request in a message and data.
 */
public class ResponseDTO {
    private final String message;
    private final Object data;

    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}