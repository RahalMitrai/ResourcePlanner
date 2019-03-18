package com.mitrai.ResourcePlanner.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ResourceNotFoundException extends ResourcePlannerException{

    public ResourceNotFoundException(String message, int errorCode){
        super(message,errorCode);
    }

    public ResourceNotFoundException(String message){
        super(message);
    }
}
