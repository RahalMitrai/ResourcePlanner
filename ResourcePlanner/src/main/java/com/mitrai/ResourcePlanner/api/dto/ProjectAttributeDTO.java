package com.mitrai.ResourcePlanner.api.dto;

import com.mitrai.ResourcePlanner.persistence.entity.DataType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter @NoArgsConstructor
public class ProjectAttributeDTO {

    private String label;

    private UUID id;

    private DataType dataType;

    private String defaultValue;
}
