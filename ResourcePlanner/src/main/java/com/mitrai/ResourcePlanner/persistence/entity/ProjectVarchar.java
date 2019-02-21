package com.mitrai.ResourcePlanner.persistence.entity;

import javax.persistence.*;

@Entity
public class ProjectVarchar {

    @EmbeddedId
    private ProjectFieldValueIdentity projectFieldValueIdentity;

    private String value;


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ProjectFieldValueIdentity getProjectFieldValueIdentity() {
        return projectFieldValueIdentity;
    }

    public void setProjectFieldValueIdentity(ProjectFieldValueIdentity projectFieldValueIdentity) {
        this.projectFieldValueIdentity = projectFieldValueIdentity;
    }
}
