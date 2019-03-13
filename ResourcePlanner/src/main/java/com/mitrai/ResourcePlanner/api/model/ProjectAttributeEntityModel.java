package com.mitrai.ResourcePlanner.api.model;


import com.mitrai.ResourcePlanner.persistence.entity.DataType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProjectAttributeEntityModel {

    private String label;

    private String id;

    private DataType dataType;

    private String defaultValue;
}
