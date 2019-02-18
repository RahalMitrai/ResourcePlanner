package com.mitrai.ResourcePlanner.persistence.entity;

import javax.persistence.*;

@Entity
public class Text {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String value;

    private int entityId;

    @ManyToOne
    @JoinColumn
    private Attribute attribute;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }
}
