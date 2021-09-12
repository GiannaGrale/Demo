package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CasesOverviewPage extends BasePage {
    private final static String endpoint = "index.php?/cases/view";
    private final static By message_Success_By = By.className("message-success");

    public CasesOverviewPage(WebDriver driver, boolean openPageByURL) {
        super(driver, openPageByURL);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getTestRailSite() + endpoint);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getMessageSuccess().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public WebElement getMessageSuccess() {
        return driver.findElement(message_Success_By);
    }
}

