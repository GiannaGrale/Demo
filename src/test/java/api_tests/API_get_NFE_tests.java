package api_tests;

import adapters.ProjectAdapter;
import baseEntities.BaseApiTest;
import models.Project;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class API_get_NFE_tests extends BaseApiTest {
    @Test
    public void getProjectsTest() {
        List<Project> projectList = new ProjectAdapter().getProjects();
        Assert.assertEquals(projectList.get(0).getName().trim(), "Test");
    }

    @Test
    public void getUsersTest() {
        List<Project> usersOfProject = new ProjectAdapter().getUsers();
        Assert.assertEquals(usersOfProject.get(0).getName().trim(), "Anna Grabovskaya");
    }

    @Test
    public void getUsersDetailsTest() {
        List<User> dataUsers = new ProjectAdapter().getAllUsersDetailsTest();
        Assert.assertEquals(dataUsers.get(0).getEmail().trim(), "giannagrale@gmail.com");
    }
}
