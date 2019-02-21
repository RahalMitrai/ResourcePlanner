package com.mitrai.ResourcePlanner.persistence.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ProjectAttribute {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String label;

    private String defaultValue;

    private String type;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<ProjectNumber> projectNumbers=new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    private Set<ProjectVarchar> projectVarchars=new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<ProjectNumber> getProjectNumbers() {
        return projectNumbers;
    }

    public void setProjectNumbers(Set<ProjectNumber> projectNumbers) {
        this.projectNumbers = projectNumbers;
    }

    public Set<ProjectVarchar> getProjectVarchars() {
        return projectVarchars;
    }

    public void setProjectVarchars(Set<ProjectVarchar> projectVarchars) {
        this.projectVarchars = projectVarchars;
    }
}
