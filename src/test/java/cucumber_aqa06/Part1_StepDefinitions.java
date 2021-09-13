package cucumber_aqa06;


import baseEntities.BaseGUIStep;

import core.ReadProperties;
import cucumber_aqa06.support.MyWebDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LoginPage;


public class Part1_StepDefinitions extends BaseGUIStep {
    ReadProperties props = ReadProperties.getInstance();
    LoginPage loginPage;
    DashboardPage dashboardPage;

    public Part1_StepDefinitions(MyWebDriver webDriver) {
        super(webDriver);
    }


    @Step
    @When("login page is opened")
    public void openLoginPage() {
        loginPage = new LoginPage(webDriver, true);
    }

    @Step
    @When("logged in with correct credentials")
    public void successfulLoginTest() {
        loginPage.setUsername(props.getLogin());
        loginPage.setPassword(props.getPassword());
        loginPage.clickLoginButton();
    }

    @Step
    @And("dashBoard page is opened")
    public void dashboardStepsEnabled() {
        dashboardPage = new DashboardPage(webDriver, true);
    }


    @Step
    @Then("border value in the email input while signing in")
    public void borderValueTest() {
        String randomChars = RandomStringUtils.randomAlphanumeric(250);
        loginPage.setUsername(randomChars);
        loginPage.setPassword(props.getPassword());
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageText(), "Email/Login or Password is incorrect. Please try again.");
    }

    @Step
    @Then("pop-up message is checked")
    public void checkOfPopUpMessage() {
        dashboardPage.getInProgressElement().click();
        Assert.assertTrue(dashboardPage.getInProgressElement().isDisplayed());
    }

    @Step
    @Then("dialogue box is checked")
    public void checkOfDialogueBox() {
        dashboardPage.getMostActiveTime().click();
        WebElement timeFrame = dashboardPage.selectTimeFrame();
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.visibilityOf(timeFrame));
        Assert.assertEquals(dashboardPage.textInTimeFrame().getText(), "Select a different time frame for the chart.");
    }
}
