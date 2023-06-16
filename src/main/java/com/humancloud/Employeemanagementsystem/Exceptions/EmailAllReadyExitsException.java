package com.humancloud.Employeemanagementsystem.Exceptions;



public class EmailAllReadyExitsException extends RuntimeException{
    String resourceName;
    String resourceField;
    String fieldValue;

    public EmailAllReadyExitsException(String resourceName, String resourceField, String fieldValue) {
        super(String.format("%s All Ready Exits With %s: %s",resourceName,resourceField,fieldValue));
        this.resourceName = resourceName;
        this.resourceField = resourceField;
        this.fieldValue = fieldValue;
    }
}
