package com.notekeeper.notes.responses;

public class ApiResponse<T> {
    private boolean success;
    private String message;
    private String error;
    private T data;

    public ApiResponse() {}

    public ApiResponse(T data, String error, String message, boolean success) {
        this.success = success;
        this.message = message;
        this.error = error;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
