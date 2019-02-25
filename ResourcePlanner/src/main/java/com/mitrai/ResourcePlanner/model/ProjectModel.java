package com.mitrai.ResourcePlanner.model;

import com.mitrai.ResourcePlanner.persistence.entity.Project;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Map;

@Getter @Setter @NoArgsConstructor
public class ProjectModel {

    @NotNull
    private String title;

    private Map<String, String> varcharAttributes;
    private Map<String, String> numberAttributes;
    private Map<String, String> dateAttributes;
}
