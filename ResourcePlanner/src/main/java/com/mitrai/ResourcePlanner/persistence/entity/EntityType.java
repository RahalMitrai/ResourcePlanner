package com.mitrai.ResourcePlanner.persistence.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class EntityType {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String label;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @OneToMany(mappedBy = "entityType")
    private Set<ResourcePlannerEntity> resourcePlannerEntities;

}
