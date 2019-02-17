package com.mitrai.ResourcePlanner.service.impl;

import com.mitrai.ResourcePlanner.persistence.entity.EntityType;
import com.mitrai.ResourcePlanner.persistence.repository.EntityTypeRepository;
import com.mitrai.ResourcePlanner.service.EntityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityTypeServiceImpl implements EntityTypeService {

    @Autowired
    private EntityTypeRepository entityTypeRepository;

    public EntityType save(EntityType entityType) {
        return entityTypeRepository.save(entityType);
    }
}
