package com.mitrai.ResourcePlanner.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor
public class ProjectAttributeValue {

    @EmbeddedId
    private CompositeProjectAttributeValueId compositeProjectAttributeValueId;

    private String value;



    public ProjectAttributeValue(long projectId,long projectAttributeId,String value){
        this.compositeProjectAttributeValueId=new CompositeProjectAttributeValueId(projectId,projectAttributeId);
        this.value=value;
    }



}
