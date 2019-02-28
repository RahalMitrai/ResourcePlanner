package com.mitrai.ResourcePlanner.persistence.entity;


import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CompositeProjectAttributeValueId implements Serializable {

    private long projectId;
    private long projectAttributeId;

    public CompositeProjectAttributeValueId(){

    }

    public CompositeProjectAttributeValueId(long projectId, long attributeId){
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
