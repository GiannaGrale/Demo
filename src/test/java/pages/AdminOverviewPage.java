package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminOverviewPage extends BasePage {
    private final static String endpoint = "index.php?/admin/projects/overview";
    private final static By successfully_delete_By = By.cssSelector(".message-success");

    public AdminOverviewPage(WebDriver driver, boolean openPageByURL) {
        super(driver, openPageByURL);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getTestRailSite() + endpoint);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getSuccessDelete().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    //Методы для проверки удаления проекта
    public WebElement getSuccessDelete(){ return driver.findElement(successfully_delete_By);}
    public String getSuccessDeleteText() {
        return getSuccessDelete().getText();
    }
}


