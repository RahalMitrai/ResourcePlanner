package com.mitrai.ResourcePlanner.service.impl;

import com.mitrai.ResourcePlanner.persistence.entity.Number;
import com.mitrai.ResourcePlanner.persistence.repository.NumberRepository;
import com.mitrai.ResourcePlanner.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NumberServiceImpl implements NumberService {

    @Autowired
    private NumberRepository numberRepository;

    public Number save(Number number){
        return numberRepository.save(number);
    }
}
