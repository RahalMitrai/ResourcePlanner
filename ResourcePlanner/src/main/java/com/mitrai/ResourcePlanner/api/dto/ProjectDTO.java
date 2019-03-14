package com.mitrai.ResourcePlanner.api.dto;

import com.mitrai.ResourcePlanner.api.model.AttributeValueModel;
import com.mitrai.ResourcePlanner.api.model.ProjectEntityModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Getter @Setter @NoArgsConstructor
public class ProjectDTO {

    @Valid
    private ProjectEntityModel projectEntity;

    @Valid
    private ArrayList<AttributeValueModel> attributesValues;

}
