package com.mitrai.ResourcePlanner.persistence.entity;

import javax.persistence.*;

@Entity
public class Number {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private int value;

    @ManyToOne
    @JoinColumn
    private Attribute attribute;

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
