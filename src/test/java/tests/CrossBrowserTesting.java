package tests;

import core.BrowserService;
import core.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
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
public class CrossBrowserTesting {
    WebDriver driver;
    ReadProperties properties;

    @BeforeTest
    public void setupTest() {
        properties = ReadProperties.getInstance();
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }

    @Test
    @Parameters({"BrowserType"})
    public void testExamplePageOnMultipleBrowsers(String browserType) {
        if (browserType.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browserType.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        ProjectStep projectStep = new LoginStep(driver)
                .correctLogin(properties.getLogin(), properties.getPassword());
        Assert.assertEquals(projectStep.getDashboardPage().getDashboardButtonText().trim(), "DASHBOARD");

    }
}