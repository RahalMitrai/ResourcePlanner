package com.mitrai.ResourcePlanner.service.impl;

import com.mitrai.ResourcePlanner.persistence.entity.Text;
import com.mitrai.ResourcePlanner.persistence.repository.TextRepository;
import com.mitrai.ResourcePlanner.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TextServiceImpl implements TextService {

    @Autowired
    private TextRepository textRepository;

    public Text save(Text text) {
        return textRepository.save(text);
    }
}
