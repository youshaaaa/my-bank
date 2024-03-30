package com.yousha.dto;

import java.util.ArrayList;
import java.util.List;

public class ErrorDto {
    private List<String> fieldNames = new ArrayList<>();

    private String errorMessage;

    public ErrorDto() {
    }

    public ErrorDto(List<String> fieldNames, String errorMessage) {
        this.fieldNames = fieldNames;
        this.errorMessage = errorMessage;
    }

    public List<String> getFieldNames() {
        return fieldNames;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
