package com.mitrai.ResourcePlanner.api.controller;

import com.mitrai.ResourcePlanner.persistence.entity.Text;
import com.mitrai.ResourcePlanner.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TextController {

    @Autowired
    private TextService textService;

    @RequestMapping(value = "save", method=RequestMethod.POST)
    public Text save(Text text){
        return textService.save(text);
    }
}
