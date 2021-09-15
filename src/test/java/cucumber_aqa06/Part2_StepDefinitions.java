package cucumber_aqa06;

import baseEntities.BaseGUIStep;
import core.ReadProperties;
import cucumber_aqa06.support.MyWebDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import pages.ProjectPage;
import steps_Anna.CaseStep;


import java.awt.*;

public class Part2_StepDefinitions extends BaseGUIStep {
    ReadProperties props = ReadProperties.getInstance();

    public Part2_StepDefinitions(MyWebDriver webDriver) {
        super(webDriver);
    }

    @And("project is created")
    public void projectIsCreated() {
        new DashboardPage(webDriver, true).getAddProjectButton().click();
        ProjectPage projectPage = new ProjectPage(webDriver, true);
        projectPage.getProjectNameInput().sendKeys(props.getProjectName());
        projectPage.getAnnouncementInput().sendKeys(props.getAnnouncementMessage());
        projectPage.getAddProjectButton().click();
    }

    @Step
    @Then("log in with incorrect credentials {string}, {string}")
    public void logInWithIncorrectCredentials(String login, String psw) {
        LoginPage loginPage = new LoginPage(webDriver, false);
        loginPage.setUsername(login);
        loginPage.setPassword(psw);
        loginPage.clickLoginBtn();
        Assert.assertEquals(loginPage.getErrorMessageText().trim(), "Email/Login or Password is incorrect. Please try again.");
    }

    @Step
    @Then("insert outbound values")
    public void insertOutboundValues() {
        String randomChars = RandomStringUtils.randomAlphanumeric(255);
        LoginPage loginPage = new LoginPage(webDriver, false);
        loginPage.setUsername(randomChars);
        loginPage.setPassword(props.getPassword());
        loginPage.clickLoginBtn();
        Assert.assertEquals(loginPage.getErrorMessageText().trim(), "Field Email/User is too long (250 characters at most).");
    }

    @Step
    @Then("upload a file to a test case in a project")
    public void createATestCaseInAProjectWithAnUploadedPicture() throws AWTException, InterruptedException {
        CaseStep caseStep = new CaseStep(webDriver)
                .addTestCaseWithFile(props.getProjectName());
        Assert.assertEquals(caseStep.getCaseOverviewPage().getMessageSuccess().getText(), "Successfully added the new test case. Add another");
    }
}