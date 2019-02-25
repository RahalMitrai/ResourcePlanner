package com.mitrai.ResourcePlanner.persistence.repository;

import com.mitrai.ResourcePlanner.persistence.entity.ProjectAttribute;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public  interface ProjectAttributeRepository extends CrudRepository<ProjectAttribute, Long> {

    ProjectAttribute findByRefId(String refId);
}
