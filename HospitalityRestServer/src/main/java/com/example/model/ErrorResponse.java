package com.example.model;

/**
 * Implements response object for error requests
 */
public class ErrorResponse implements HospitalityEntity {

    public static final String CONFLICT_MESSAGE = "All rooms of this type were reserved. Please, choose different order.";

    private Integer error = null;

    private String message = null;

    public Integer getError() {
        return error;
    }

    public ErrorResponse(Integer errorCode, String messageString) {
        error = errorCode;
        message = messageString;
    }

    public ErrorResponse(String messageString) {
        message = messageString;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
