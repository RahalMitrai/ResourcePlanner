package com.mitrai.ResourcePlanner.persistence.entity;


import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class CompositeProjectAttributeValueId implements Serializable {

    private String projectId;
    private String projectAttributeId;

    public CompositeProjectAttributeValueId(){

    }

    public CompositeProjectAttributeValueId(String projectId, String attributeId){
        this.projectId=projectId;
        this.projectAttributeId=attributeId;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositeProjectAttributeValueId compositeProjectAttributeValueId = (CompositeProjectAttributeValueId) o;
        if (projectId != compositeProjectAttributeValueId.projectId) return false;
        return projectAttributeId == compositeProjectAttributeValueId.projectAttributeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, projectAttributeId);
    }


}
