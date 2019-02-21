package com.mitrai.ResourcePlanner.persistence.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String title;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<ProjectNumber> projectNumbers=new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    private Set<ProjectVarchar> projectVarchars=new HashSet<>();

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
