package com.mitrai.ResourcePlanner.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor
public class ProjectVarchar {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String value;

    private long projectId;

    private long projectAttributeId;

}
