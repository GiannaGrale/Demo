package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CasePage extends BasePage {
    private final static String endpoint = "index.php?/cases";
    private final static By test_Cases_Title_By = By.id("title");
    private final static By test_Cases_ADD_By = By.id("accept");
    private final static By delete_Attachments_By = By.id("libraryDeleteAttachment");


    public CasePage(WebDriver driver, boolean openPageByURL) {
        super(driver, openPageByURL);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getTestRailSite() + endpoint);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getTestCaseTitle().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public WebElement getTestCaseTitle() {
        return driver.findElement(test_Cases_Title_By);
    }

    public WebElement getTestCaseADD() {
        return driver.findElement(test_Cases_ADD_By);
    }

    public WebElement deleteAttachment() {
        return driver.findElement(delete_Attachments_By);
    }
}

