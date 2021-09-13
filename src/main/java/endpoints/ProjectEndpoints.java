package endpoints;

public interface ProjectEndpoints {
    String ADD_PROJECT = "/index.php?/api/v2/add_project";
    String UPDATE_PROJECT = "index.php?/api/v2/update_project/%d";
    String GET_PROJECTS = "index.php?/api/v2/get_projects";
    String GET_PROJECT ="index.php?/api/v2/get_project/%d";
}
