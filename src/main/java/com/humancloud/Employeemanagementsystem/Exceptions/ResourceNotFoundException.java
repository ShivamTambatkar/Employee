package com.humancloud.Employeemanagementsystem.Exceptions;

public class ResourceNotFoundException extends RuntimeException{
     String resourceName;
     String resourcefield;
      long fieldValue;

    public ResourceNotFoundException(String resourceName, String resourcefield, long fieldValue) {
        super(String.format("%s not found with %s:%s",resourceName,resourcefield,fieldValue));
        this.resourceName = resourceName;
        this.resourcefield = resourcefield;
        this.fieldValue = fieldValue;
    }
}
