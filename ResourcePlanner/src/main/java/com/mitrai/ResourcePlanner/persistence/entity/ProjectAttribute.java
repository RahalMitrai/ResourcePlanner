package com.mitrai.ResourcePlanner.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor
public class ProjectAttribute implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String label;

    private String defaultValue;

    private DataType dataType;

    /*@OneToMany(cascade = CascadeType.ALL)
    private Set<ProjectNumber> projectNumbers=new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    private Set<ProjectVarchar> projectVarchars=new HashSet<>();
*/
}
