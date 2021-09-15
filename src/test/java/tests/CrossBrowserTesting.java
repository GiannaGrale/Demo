package tests;

import baseEntities.BaseCross;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import steps_Anna.LoginStep;
import steps_Anna.ProjectStep;
import utils.Listener;


@Listeners({Listener.class})
public class CrossBrowserTesting extends BaseCross {

    @Test
    public void test (){
        ProjectStep projectStep = new LoginStep(driver)
                .correctLogin(properties.getLogin(), properties.getPassword());
        Assert.assertEquals(projectStep.getDashboardPage().getDashboardButtonText().trim(), "DASHBOARD");

    }
}