package steps_Boris;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;


public class LoginStep extends BaseStep {

    public  LoginStep(WebDriver driver) {
        super(driver);
    }

    public ProjectStep successfulLogin(String username, String password) {
        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        return new ProjectStep(driver);
    }

    public LoginStep failedLogin(String username, String password) {
        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        return this;
    }

    public DashboardSteps correctLogin(String username, String password) {
        successfulLogin(username, password);
        return new DashboardSteps(driver);
    }
}