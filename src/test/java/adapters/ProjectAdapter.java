package adapters;

import com.google.common.reflect.TypeToken;
import endpoints.UserEndpoints;
import models.Project;
import endpoints.ProjectEndpoints;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.User;
import org.apache.http.HttpStatus;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ProjectAdapter extends BaseAdapter {

    public List<User> getAllUsersDetailsTest() {
        Response response = given()
                .when()
                .get(UserEndpoints.GET_USERS)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        return gson.fromJson(response.asString().trim(), new TypeToken<List<User>>() {
        }.getType());
    }

    public List<Project> getUsers() {
        Response response = given()
                .when()
                .get(UserEndpoints.GET_USERS)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        return gson.fromJson(response.asString().trim(), new TypeToken<List<Project>>() {
        }.getType());
    }

    public List<Project> getProjects() {
        Response response = given()
                .when()
                .get(ProjectEndpoints.GET_PROJECTS)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();

        return gson.fromJson(response.asString().trim(), new TypeToken<List<Project>>() {
        }.getType());
    }

    public Project updateProject(Project project, int projectID) {
        Response response = given()
                .body(project, ObjectMapperType.GSON)
                .when()
                .post(String.format(ProjectEndpoints.UPDATE_PROJECT, projectID))
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        return gson.fromJson(response.asString().trim(), Project.class);
    }

    public Project addProject(Project project) {
        Response response = given()
                .body(project, ObjectMapperType.GSON)
                .when()
                .post(ProjectEndpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        return gson.fromJson(response.asString().trim(), Project.class);
    }
}