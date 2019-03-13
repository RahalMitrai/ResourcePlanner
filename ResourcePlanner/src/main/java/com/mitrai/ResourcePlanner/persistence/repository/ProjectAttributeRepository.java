package com.mitrai.ResourcePlanner.persistence.repository;

import com.mitrai.ResourcePlanner.persistence.entity.ProjectAttribute;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
public  interface ProjectAttributeRepository extends CrudRepository<ProjectAttribute, Long> {

    ProjectAttribute findById(String id);

    Optional<ProjectAttribute> findOneById(String id);

    void deleteById(String uuid);
}
