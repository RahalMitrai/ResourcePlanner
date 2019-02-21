package com.mitrai.ResourcePlanner.persistence.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProjectFieldValueIdentity implements Serializable {

    private long projectId;

    private long projectAttributeId;

    public ProjectFieldValueIdentity(){

    }

    public ProjectFieldValueIdentity(long projectId,long projectAttributeId){
        this.projectId=projectId;
        this.projectAttributeId=projectAttributeId;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getProjectAttributeId() {
        return projectAttributeId;
    }

    public void setProjectAttributeId(long projectAttributeId) {
        this.projectAttributeId = projectAttributeId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectFieldValueIdentity)) return false;
        ProjectFieldValueIdentity that = (ProjectFieldValueIdentity) o;
        return Objects.equals(getProjectId(), that.getProjectId()) &&
                Objects.equals(getProjectAttributeId(), that.getProjectAttributeId());
    }


    @Override
    public int hashCode(){
        return Objects.hash(getProjectId(),getProjectAttributeId());
    }


}
