package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CrossBrowser {
    public WebDriver driver;

    public WebDriver selectDriver (String browserType) {
        switch (browserType) {
            case "Chrome":
                WebDriverManager.chromedriver().setup ();
                driver = new ChromeDriver();
                break;
            case "Firefox":
                WebDriverManager.firefoxdriver().setup ();
                driver = new FirefoxDriver();
                break;
            case "Edge":
                WebDriverManager.edgedriver ().setup ();
                driver = new EdgeDriver();
                break;
            default:
        }
        return driver;
    }
}
