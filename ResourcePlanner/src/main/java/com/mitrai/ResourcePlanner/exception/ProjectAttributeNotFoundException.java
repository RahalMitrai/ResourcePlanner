package com.mitrai.ResourcePlanner.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProjectAttributeNotFoundException  extends ResourceNotFoundException{

    public ProjectAttributeNotFoundException(String message, int errorCode){
        super(message, errorCode);
    }
}
