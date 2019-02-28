package com.mitrai.ResourcePlanner.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Attribute {

    private String refId;
    private String value;

    public Attribute(String refId,String value){
        this.refId=refId;
        this.value=value;
    }
}
