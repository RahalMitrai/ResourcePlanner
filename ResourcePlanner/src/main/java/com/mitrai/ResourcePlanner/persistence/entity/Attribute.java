package com.mitrai.ResourcePlanner.persistence.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Attribute {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String label;
    private String defaultValue;

    /*@OneToMany(mappedBy = "attribute")
    private Set<Number> numbers;

    @OneToMany(mappedBy = "attribute")
    private Set<Text> texts;*/
    @ManyToOne
    @JoinColumn
    private EntityType entityType;
    public EntityType getEntityType() {
        return entityType;
    }

    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }




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

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    //private ResourcePlannerEntity project fk

}
