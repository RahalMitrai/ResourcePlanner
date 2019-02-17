package com.mitrai.ResourcePlanner.api.controller;

import com.mitrai.ResourcePlanner.persistence.entity.ResourcePlannerEntity;
import com.mitrai.ResourcePlanner.service.ResourcePlannerEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourcePlannerEntityController {
	
	@Autowired
	private ResourcePlannerEntityService resourcePlannerEntityService;

	/*@RequestMapping(value = "projects")
    public ResourcePlannerEntity projectList() {
        return prjRepo.findById(2L).get();
    }*/

    @RequestMapping(value = "save", method=RequestMethod.POST)
    public ResourcePlannerEntity save(ResourcePlannerEntity resourcePlannerEntity){
	    return resourcePlannerEntityService.save(resourcePlannerEntity);

    }
}
