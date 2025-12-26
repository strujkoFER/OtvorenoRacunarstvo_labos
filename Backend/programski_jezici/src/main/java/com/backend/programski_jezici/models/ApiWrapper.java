package com.backend.programski_jezici.models;

public class ApiWrapper<T> {
    private T response;

    public ApiWrapper(T response) {
        this.response = response;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}