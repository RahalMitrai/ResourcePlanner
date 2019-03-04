package com.mitrai.ResourcePlanner.persistence.entity;

import com.mitrai.ResourcePlanner.model.ProjectAttributeModel;
import com.mitrai.ResourcePlanner.service.ProjectAttributeService;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProjectAttributeTest {

   /* @Autowired
    private ProjectAttributeService projectAttributeService;

    @private ModelMapper modelMapper;

    @Test
    public void createProjectAttribute(){
        ProjectAttribute projectAttribute=new ProjectAttribute();
        projectAttribute.setLabel("region_create_test");
        projectAttribute.setDefaultValue("UK");
        projectAttribute.setDataType(DataType.VARCHAR);
        String refId=UUID.randomUUID().toString();
        projectAttribute.setRefId(refId);
        ProjectAttribute projectAttributeSaved=projectAttributeService.save(projectAttribute);
        Assert.assertSame(projectAttribute,projectAttributeSaved);
    }

    @Test
    public void deleteProjectAttribute(){
        try {

            //create new project
        ProjectAttribute projectAttribute=new ProjectAttribute();
        projectAttribute.setLabel("region_delete_test");
        projectAttribute.setDefaultValue("UK");
        projectAttribute.setDataType(DataType.VARCHAR);
        String refId=UUID.randomUUID().toString();
        projectAttribute.setRefId(refId);
        ProjectAttribute projectAttributeSaved=projectAttributeService.save(projectAttribute);

        //delete project by refId
        projectAttributeService.delete(projectAttributeSaved.getRefId());

        ProjectAttribute projectAttribute1=projectAttributeService.findByRefId(refId);
        Assert.assertSame(null,projectAttribute1);
        } catch (Exception e) {
          System.out.println(e);
        }

    }

    @Test
    public void updateProjectAttribute(){
        try{
            //create new project
            ProjectAttributeModel projectAttributeModel=new ProjectAttributeModel();
            projectAttributeModel.setLabel("region_update_test");
            projectAttributeModel.setDefaultValue("UK");
            projectAttributeModel.setDataType(DataType.VARCHAR);
            ProjectAttribute projectAttribute=modelMapper.map(projectAttributeModel,ProjectAttributeModel);
            String refId=UUID.randomUUID().toString();
            projectAttribute.setRefId(refId);
            projectAttribute.setLabel("region_update_test");
            projectAttribute.setDefaultValue("UK");
            projectAttribute.setDataType(DataType.VARCHAR);
            ProjectAttribute projectAttributeExist=projectAttributeService.save(projectAttribute);

            //update project by Id
            ProjectAttribute projectAttribute1=new ProjectAttribute();
            projectAttribute1.setRefId(projectAttributeExist.getRefId());
            projectAttribute1.setDataType(DataType.VARCHAR);
            projectAttribute1.setDefaultValue("UK");
            projectAttribute1.setLabel("region_update_test_updated");
            projectAttributeService.update(projectAttribute1);


            ProjectAttribute projectAttribute2=projectAttributeService.findByRefId(projectAttribute1.getRefId());
            Assert.assertSame(projectAttribute2,projectAttribute1);

        }catch(Exception e){
            System.out.println(e);
        }
    }*/

}