package com.backend.programski_jezici.models;

public class ApiWrapper<T> {
    private T response;
    private int statusCode;
    private String statusMessage;

    public ApiWrapper(T response, int statusCode) {
        this.response = response;
        this.statusCode = statusCode;
        switch (statusCode) {
            case 200:
                this.statusMessage = "OK";
                break;
            case 404:
                this.statusMessage = "Not Found";
                break;
            case 201:
                this.statusMessage = "Created";
                break;
            case 204:
                this.statusMessage = "No Content";
                break;
            case 405:
                this.statusMessage = "Method Not Allowed";
                break;
            case 500:
                this.statusMessage = "Internal Server Error";
                break;
            default:
                this.statusMessage = null;
        }
    }

    public T getResponse() {
        return this.response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}