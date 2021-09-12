package steps_Boris;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.ProjectPage;


public class ProjectStep extends BaseStep {
    public ProjectStep(WebDriver driver) {
        super(driver);
    }

    public ProjectStep addAndDeleteProject(String projectName) {
        DashboardPage dashboardPage = new DashboardPage(driver, true);
        dashboardPage.getAddProjectButton().click();
        ProjectPage projectPage = new ProjectPage(driver, true);
        projectPage.setNameInput(projectName);
        projectPage.clickAddProject();
        projectPage.deleteProject(projectName);
        projectPage.getDeleteConfirmationWindow().click();
        projectPage.getDeleteConfirmationButton().click();
        return this;
    }
}