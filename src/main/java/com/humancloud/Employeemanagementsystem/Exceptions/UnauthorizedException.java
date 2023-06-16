package com.humancloud.Employeemanagementsystem.Exceptions;

public class UnauthorizedException extends RuntimeException{
    String resourceName;
    String resourcefield;
    long fieldValue;

    public UnauthorizedException(String resourceName, String resourcefield, long fieldValue) {
        super(String.format("%s is not authorized to approve this leave application %s:%s",resourceName,resourcefield,fieldValue));
        this.resourceName = resourceName;
        this.resourcefield = resourcefield;
        this.fieldValue = fieldValue;
    }
}

