package com.mitrai.ResourcePlanner.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ResourcePlannerException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String errorMsg;
    private int errorCode;

    public ResourcePlannerException(String errorMsg){
        super();
        this.errorMsg=errorMsg;

    }

    public ResourcePlannerException(String errorMsg,int errorCode){
        super();
        this.errorMsg=errorMsg;
        this.errorCode=errorCode;
    }

}
