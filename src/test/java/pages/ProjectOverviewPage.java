package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectOverviewPage extends BasePage {

    private final static String endpoint = "index.php?/projects/overview";
    private final static By test_Cases_Add_By = By.id("sidebar-cases-add");

    public ProjectOverviewPage(WebDriver driver, boolean openPageByURL) {
        super(driver, openPageByURL);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getTestRailSite() + endpoint);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getTestCaseADDButton().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public WebElement getTestCaseADDButton() {
        return driver.findElement(test_Cases_Add_By);
    }
}


