package com.mitrai.ResourcePlanner.persistence.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Attribute {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private long label;
    private String defaultValue;

    @OneToMany(mappedBy = "attribute")
    private Set<Number> numbers;

    @OneToMany(mappedBy = "attribute")
    private Set<Text> texts;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLabel() {
        return label;
    }

    public void setLabel(long label) {
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
