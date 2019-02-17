package com.mitrai.ResourcePlanner.service.impl;

import com.mitrai.ResourcePlanner.persistence.entity.ResourcePlannerEntity;
import com.mitrai.ResourcePlanner.persistence.repository.ResourcePlannerEntityRepository;
import com.mitrai.ResourcePlanner.service.ResourcePlannerEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourcePlannerEntityServiceImpl implements ResourcePlannerEntityService {

    @Autowired
    private ResourcePlannerEntityRepository resourcePlannerEntityRepository;

    public ResourcePlannerEntity save(ResourcePlannerEntity resourcePlannerEntity) {
        return resourcePlannerEntityRepository.save(resourcePlannerEntity);
    }
}
