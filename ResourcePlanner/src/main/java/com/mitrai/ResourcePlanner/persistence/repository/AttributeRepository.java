package com.mitrai.ResourcePlanner.persistence.repository;

import com.mitrai.ResourcePlanner.persistence.entity.Attribute;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public  interface AttributeRepository extends CrudRepository<Attribute, Long> {
}
