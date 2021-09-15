package baseEntities;

import core.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import utils.CrossBrowser;


public class BaseCross  {
    public WebDriver driver;
    public ReadProperties properties;

    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }

    @BeforeTest
    @Parameters({"BrowserType"})
    public void setUp(String browserType) {
        properties = ReadProperties.getInstance();
    }
}
