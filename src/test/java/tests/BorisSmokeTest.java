package tests;

import baseEntities.BaseTest;
import io.qameta.allure.Feature;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.ProjectPage;
import steps_Boris.DashboardSteps;
import steps_Boris.LoginStep;
import steps_Boris.ProjectStep;


public class BorisSmokeTest extends BaseTest {

    @Feature("Project")
    @Test(description = "adding and deleting a project test")
    public void positiveTest1() {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.successfulLogin(properties.getLogin(), properties.getPassword());
        //Добавляем и удаляем проект через степ
        ProjectPage projectPage = new ProjectPage(driver, true);
        ProjectStep projectStep = new ProjectStep(driver);
        projectStep.addAndDeleteProject(properties.getNameProject());
        Assert.assertEquals(projectPage.getSuccessDelete().getText(), "Successfully deleted the project.", "Project not delete");
    }

    @Feature("Login")
    @Test(description = "boundary value of 250 (including) symbols test")
    public void positiveTest2()  {
        String randomChars = RandomStringUtils.randomAlphanumeric(250);
        LoginStep loginStep = new LoginStep(driver);
        loginStep.failedLogin(randomChars, properties.getPassword());
        Assert.assertEquals(loginStep.getLoginPage().getErrorMessageText(), "Email/Login or Password is incorrect. Please try again.");
    }


    @Feature("Pop-up message")
    @Test(description = "pop-up screen check")
    public void positiveTest3() {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.successfulLogin(properties.getLogin(), properties.getPassword());
        DashboardSteps dashboardSteps = new DashboardSteps(driver);
        dashboardSteps.clickOnPopUpMessage();
        Assert.assertTrue(new DashboardPage(driver, false).getInProgressElement().isDisplayed());
    }

    @Feature("Dialogue box")
    @Test(description = "dialog box test")
    public void positiveTest4() {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.successfulLogin(properties.getLogin(), properties.getPassword());
        DashboardSteps dashboardSteps = new DashboardSteps(driver);
        dashboardSteps.clickOnDialogueBox();
        Assert.assertEquals(new DashboardPage(driver, false).textInTimeFrame().getText(), "Select a different time frame for the chart.");
    }

    //---------------- Invocations

    @Feature("Project")
    @Test(description = "adding and deleting a project test")
    public void positiveInvocationsTest() {
        ProjectStep projectStep = new LoginStep(driver)
                .successfulLogin(properties.getLogin(), properties.getPassword())
                .addAndDeleteProject(properties.getNameProject());
        Assert.assertEquals(projectStep.getAdminOverviewPage().getSuccessDelete().getText(), "Successfully deleted the project.", "Project not delete");
    }

    @Feature("Login")
    @Test(description = "boundary value of 250 (including) symbols test")
    public void positiveInvocationsTest2()  {
        String randomChars = RandomStringUtils.randomAlphanumeric(250);
        LoginStep loginStep = new LoginStep(driver)
                .failedLogin(randomChars, properties.getPassword());
        Assert.assertEquals(loginStep.getLoginPage().getErrorMessageText(), "Email/Login or Password is incorrect. Please try again.");
    }

    @Feature("Pop-up message")
    @Test(description = "pop-up screen check")
    public void positiveInvocationsTest3() {
        DashboardSteps dashboardSteps = new LoginStep(driver)
                .correctLogin (properties.getLogin(), properties.getPassword())
                .clickOnPopUpMessage();
        Assert.assertTrue(dashboardSteps.getDashboardPage().getInProgressElement().isDisplayed());
    }

    @Feature("Dialogue box")
    @Test(description = "dialog box test")
    public void positiveInvocationsTest4() {
        DashboardSteps dashboardSteps = new LoginStep(driver)
                .correctLogin (properties.getLogin(), properties.getPassword())
                .clickOnDialogueBox();
        Assert.assertEquals(dashboardSteps.getDashboardPage().textInTimeFrame().getText(), "Select a different time frame for the chart.");
    }
}

