package utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;


public class CrossBrowser {

    static WebDriver driver;

    public static WebDriver selectDriver (String browser) {
        switch (browser) {
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
                driver = new FirefoxDriver();
                break;
            default:
        }
        return driver;
    }

}
