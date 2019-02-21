package com.mitrai.ResourcePlanner.persistence.entity;

import javax.persistence.*;

@Entity
public class ProjectNumber {

    @EmbeddedId
    private ProjectFieldValueIdentity projectFieldValueIdentity;

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ProjectFieldValueIdentity getProjectFieldValueIdentity() {
        return projectFieldValueIdentity;
    }

    public void setProjectFieldValueIdentity(ProjectFieldValueIdentity projectFieldValueIdentity) {
        this.projectFieldValueIdentity = projectFieldValueIdentity;
    }

}
