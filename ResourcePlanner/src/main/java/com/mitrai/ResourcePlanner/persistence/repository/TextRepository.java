package com.mitrai.ResourcePlanner.persistence.repository;

import com.mitrai.ResourcePlanner.persistence.entity.Text;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TextRepository extends CrudRepository<Text, Long> {
}
