package com.example.api.cars.exception;

public class FieldErrorOutputDto {

    private String field;
    private String message;

    @Deprecated
    public FieldErrorOutputDto() { }

    public FieldErrorOutputDto(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
