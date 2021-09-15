package baseEntities;

import core.ReadProperties;
import org.openqa.selenium.WebDriver;
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
        driver =  new CrossBrowser(browserType).getDriver();

    }
}
