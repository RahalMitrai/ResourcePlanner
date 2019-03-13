package com.mitrai.ResourcePlanner.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter @Setter @NoArgsConstructor
public class ProjectAttributeValue {

    @EmbeddedId
    private CompositeProjectAttributeValueId compositeProjectAttributeValueId;

    private String value;



    public ProjectAttributeValue(String projectId, String projectAttributeId, String value){
        this.compositeProjectAttributeValueId=new CompositeProjectAttributeValueId(projectId,projectAttributeId);
        this.value=value;
    }



}
