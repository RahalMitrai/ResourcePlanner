package com.mitrai.ResourcePlanner.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter @Setter @NoArgsConstructor
public class ProjectAttribute implements Serializable {

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid2")
    private String id;

    private String label;

    private String defaultValue;

    @Enumerated(EnumType.STRING)
    private DataType dataType;

    /*@OneToMany(cascade = CascadeType.ALL)
    private Set<ProjectNumber> projectNumbers=new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    private Set<ProjectVarchar> projectVarchars=new HashSet<>();
*/
}
