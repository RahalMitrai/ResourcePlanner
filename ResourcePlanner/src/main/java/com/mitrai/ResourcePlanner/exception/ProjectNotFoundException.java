package com.mitrai.ResourcePlanner.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProjectNotFoundException extends ResourceNotFoundException {


    public ProjectNotFoundException(String message, int errorCode) {
        super(message, errorCode);
    }

    public ProjectNotFoundException(String message){
        super(message);
    };
}
