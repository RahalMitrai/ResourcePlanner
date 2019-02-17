package com.mitrai.ResourcePlanner.service.impl;

import com.mitrai.ResourcePlanner.persistence.entity.Attribute;
import com.mitrai.ResourcePlanner.persistence.repository.AttributeRepository;
import com.mitrai.ResourcePlanner.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttributeServiceImpl implements AttributeService {

    @Autowired
    private AttributeRepository attributeRepository;

    public Attribute save(Attribute attribute) {
        return attributeRepository.save(attribute);
    }
}
