package com.mitrai.ResourcePlanner.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor
public class Project implements Serializable {

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid2")
    private String id;

    private String title;
    private static final long serialVersionUID = 1L;


   /* @OneToMany(cascade = CascadeType.ALL)
    private Set<ProjectNumber> projectNumbers=new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    private Set<ProjectVarchar> projectVarchars=new HashSet<>();
    */

}
