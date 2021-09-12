package steps_Anna;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.ProjectPage;


public class ProjectStep extends BaseStep {


    public ProjectStep(WebDriver driver) {
        super(driver);
    }

    @Step("Add a project with the following name '{projectName}', and announcement '{projectName}'")
    public ProjectStep addProject(String projectName, String announcement) {
        new DashboardPage(driver, true).getAddProjectButton().click();
        ProjectPage projectPage = new ProjectPage(driver, true);
        projectPage.getProjectNameInput().sendKeys(projectName);
        projectPage.getAnnouncementInput().sendKeys(announcement);
        projectPage.getAddProjectButton().click();
        return this;
    }

    @Step("Add a project with the following name '{projectName}', and announcement '{projectName}'")
    public CaseStep addProjectWithFutureTestCase(String projectName, String announcement) {
        addProject(projectName, announcement);
        return new CaseStep(driver);
    }
}

