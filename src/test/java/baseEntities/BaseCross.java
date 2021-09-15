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
    public void selectDriver (String browserType) {
        properties = ReadProperties.getInstance();
            switch (browserType) {
                case "Chrome" :
                    WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("disable-gpu");
                    chromeOptions.addArguments("--start-maximized");
                    chromeOptions.setHeadless(ReadProperties.getInstance().isHeadless());
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "Firefox" :
                    WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setHeadless(ReadProperties.getInstance().isHeadless());
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                case "Edge" :
                    WebDriverManager.getInstance(DriverManagerType.EDGE).setup();
                    driver = new EdgeDriver();
                    break;
                default :
                    throw new AssertionError("This browser is not supported");
            }
        }

        public WebDriver getDriver() {
            return driver;
        }

}
