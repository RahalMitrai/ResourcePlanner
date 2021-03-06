package com.mitrai.ResourcePlanner.api.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class AttributeValueModel {

    @NotNull
    private String id; //attribute refernce Id

    private String value;

    public AttributeValueModel(String id,String value){
        this.id=id;
        this.value=value;
    }
}
