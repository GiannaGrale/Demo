package api_tests;

import adapters.ProjectAdapter;
import baseEntities.BaseApiTest;
import models.Project;
import models.ProjectTypes;
import org.testng.Assert;
import org.testng.annotations.Test;


public class API_post_test extends BaseApiTest {
    private int projectID;

    @Test
    public void projectAddTest () {
        Project newProject = Project.builder()
                .name("Our Diploma API test")
                .announcement("Hey, I am a test")
                .suite_mode(ProjectTypes.SINGLE_SUITE_MODE)
                .build();
        Project addProject = new ProjectAdapter().addProject(newProject);
        Assert.assertEquals(newProject.getName().trim(), "Our Diploma API test");
        projectID = addProject.getId();

    }

    @Test(dependsOnMethods = "projectAddTest")
    public void updateProjectTest () {
        Project projectUpdate = Project.builder()
                .name("Updated Diploma")
                .announcement("Hey, I am a diploma test")
                .is_completed(true)
                .suite_mode(ProjectTypes.SINGLE_SUITE_MODE)
                .build();

        Project updatedProject = new ProjectAdapter().updateProject(projectUpdate,projectID);
        Assert.assertEquals(updatedProject.getName().trim(), "Updated Diploma");
    }
}
