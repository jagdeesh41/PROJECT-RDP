package com.rdp.printing.common.exception;

public class ResourceNotFoundException extends RuntimeException{

    private String resourceName;
    private long resourceId;

    public ResourceNotFoundException(String resourceName, long resourceId) {
        super(String.format("%s not found with id %d",resourceName,resourceId));
        this.resourceName = resourceName;
        this.resourceId = resourceId;
    }
}
