package com.mitrai.ResourcePlanner.api.dto;

import com.mitrai.ResourcePlanner.api.model.AttributeValueModel;
import com.mitrai.ResourcePlanner.api.model.ProjectEntityModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Getter @Setter @NoArgsConstructor
public class ProjectDTO {

    @Valid
    private ProjectEntityModel projectEntity;

    @Valid
    private ArrayList<AttributeValueModel> attributesValues;

    @Override
    public String toString() {
        String attributes = this.attributesValues.stream().map(Object::toString).collect(Collectors.joining(", "));
        return this.projectEntity.getId() + "#" + this.projectEntity.getTitle()+ "#" + attributes;
    }

}
