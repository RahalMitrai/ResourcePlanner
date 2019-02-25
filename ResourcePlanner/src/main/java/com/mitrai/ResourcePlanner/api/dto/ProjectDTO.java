package com.mitrai.ResourcePlanner.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Map;

@Getter @Setter @NoArgsConstructor
public class ProjectDTO {

    @NotNull
    private String title;

    private Map<String, String> attributes;
}
