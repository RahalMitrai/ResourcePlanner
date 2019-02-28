package com.mitrai.ResourcePlanner.model;

import com.mitrai.ResourcePlanner.persistence.entity.Project;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Getter @Setter @NoArgsConstructor
public class ProjectModel {

    @NotNull
    private Project project;

    private ArrayList<Attribute> attributes;

    public ProjectModel(Project project,ArrayList<Attribute> attributes){
        this.project=project;
        this.attributes=attributes;
    }
}
