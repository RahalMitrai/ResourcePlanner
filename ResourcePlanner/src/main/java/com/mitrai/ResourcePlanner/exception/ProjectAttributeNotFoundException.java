package com.mitrai.ResourcePlanner.exception;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@NoArgsConstructor
public class ProjectAttributeNotFoundException  extends ResourceNotFoundException{

    @Value("Project attribute is not found in the database")
    private String message;

    @Value("10")
    private int errorCode;

    public ProjectAttributeNotFoundException(String message, int errorCode){
        super(message, errorCode);
    }
}
