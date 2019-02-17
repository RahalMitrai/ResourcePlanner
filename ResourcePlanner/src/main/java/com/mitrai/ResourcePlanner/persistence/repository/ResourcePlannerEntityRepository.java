package com.mitrai.ResourcePlanner.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mitrai.ResourcePlanner.persistence.entity.ResourcePlannerEntity;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ResourcePlannerEntityRepository extends CrudRepository<ResourcePlannerEntity, Long>{

}
