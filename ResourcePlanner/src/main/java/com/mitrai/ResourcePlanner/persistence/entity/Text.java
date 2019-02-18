package com.mitrai.ResourcePlanner.persistence.entity;

import javax.persistence.*;

@Entity
public class Text {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String value;

    private long entityId;

    @ManyToOne
    @JoinColumn
    private Attribute attribute;

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

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

    public long getEntityId() {
        return entityId;
    }

    public void setEntityId(long entityId) {
        this.entityId = entityId;
    }
}
