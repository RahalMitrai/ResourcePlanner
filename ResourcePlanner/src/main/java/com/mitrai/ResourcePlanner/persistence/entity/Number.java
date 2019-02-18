package com.mitrai.ResourcePlanner.persistence.entity;

import javax.persistence.*;

@Entity
public class Number {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private int value;

    private long entityId;


    @ManyToOne
    @JoinColumn
    private Attribute attribute;
    public long getEntityId() {
        return entityId;
    }

    public void setEntityId(long entityId) {
        this.entityId = entityId;
    }

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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
