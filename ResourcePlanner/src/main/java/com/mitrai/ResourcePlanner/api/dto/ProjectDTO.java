package com.mitrai.ResourcePlanner.api.dto;

import com.mitrai.ResourcePlanner.model.Attribute;
import com.mitrai.ResourcePlanner.persistence.entity.Project;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Map;

@Getter @Setter @NoArgsConstructor
public class ProjectDTO {

    @NotNull
    private Project project;

    private ArrayList<Attribute> attributes;

}
