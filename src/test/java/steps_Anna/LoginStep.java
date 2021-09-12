package steps_Anna;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LoginPage;

public class LoginStep extends BaseStep {

    public LoginStep(WebDriver driver) {
        super(driver);
    }

    @Step("Incorrect log into system with credentials '{username}', '{password}'")
    public LoginStep incorrectLogin(String username, String password) {
        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLoginBtn();
        return this;
    }

    @Step("Successful log into system with credentials '{username}', '{password}'")
    public ProjectStep correctLogin (String username, String password) {
        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        WebElement button = loginPage.getLoginButton();
        loginPage.clickLoginBtn();
        wait.waitForInvisibility(button);
        return new ProjectStep(driver);
    }
}

