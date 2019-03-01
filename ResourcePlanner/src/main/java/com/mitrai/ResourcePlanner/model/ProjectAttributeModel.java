package com.mitrai.ResourcePlanner.model;

import com.mitrai.ResourcePlanner.persistence.entity.DataType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ProjectAttributeModel {

    private String label;

    private String refId;

    private DataType dataType;

    private String defaultValue;
}
