package com.mitrai.ResourcePlanner.api.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class ProjectEntityModel {

    private String id;

    @NotNull
    private String title;
}
