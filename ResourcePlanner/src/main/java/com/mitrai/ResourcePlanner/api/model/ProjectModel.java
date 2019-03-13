package com.mitrai.ResourcePlanner.api.model;

import com.mitrai.ResourcePlanner.persistence.entity.Project;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class ProjectModel {

    @NotNull
    private ProjectEntityModel projectEntity;

    private ArrayList<AttributeValueModel> attributesValues;

    public ProjectModel(ProjectEntityModel projectEntity,ArrayList<AttributeValueModel> attributesValues){
        this.projectEntity=projectEntity;
        this.attributesValues=attributesValues;
    }
}
