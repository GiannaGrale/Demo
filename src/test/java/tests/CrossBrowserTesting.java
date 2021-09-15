package tests;

import baseEntities.BaseCross;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import steps_Anna.LoginStep;
import steps_Anna.ProjectStep;
import utils.Listener;


@Listeners({Listener.class})
public class CrossBrowserTesting extends BaseCross {

    @Test
    @Parameters({"BrowserType"})
    public void test(String browserType){
        switch (browserType) {
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "Opera":
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                break;
            default:
        }
        ProjectStep projectStep = new LoginStep(driver)
                .correctLogin(properties.getLogin(), properties.getPassword());
        Assert.assertEquals(projectStep.getDashboardPage().getDashboardButtonText().trim(), "DASHBOARD");

    }
}