package tests;

import baseEntities.BaseCross;
import core.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import steps_Anna.LoginStep;
import steps_Anna.ProjectStep;
import utils.Listener;


@Listeners({Listener.class})
public class CrossBrowserTesting extends BaseCross {
     ReadProperties properties = ReadProperties.getInstance();


    @Test
    public void test(){
        ProjectStep projectStep = new LoginStep(driver)
                .correctLogin(properties.getLogin(), properties.getPassword());
        Assert.assertEquals(projectStep.getDashboardPage().getDashboardButtonText().trim(), "DASHBOARD");

    }
}