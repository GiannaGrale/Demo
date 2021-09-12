package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class DashboardPage extends BasePage {
    private final static String endpoint = "index.php?/dashboard";
    private final static By navigation_Dashboard_By = By.id("navigation-dashboard");
    private final static By add_Project_Button_By = By.id("sidebar-projects-add");
    private final static String choose_project_By = "//*[contains(text(), 'replace')]";
    private final static By most_Active_Time_By = By.cssSelector(".link.link-tooltip");
    private final static By select_Time_Frame_By = By.id("ui-dialog-title-selectTimeframeDialog");
    private final static By text_in_Time_Frame_By = By.xpath("//div[@class='form-description']");
    private final static By in_Progress_By = By.id("inProgressLink");



    public DashboardPage(WebDriver driver, boolean openPageByURL) {
        super(driver, openPageByURL);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getTestRailSite() + endpoint);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getDashboardButton().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }


    public WebElement getDashboardButton() {
        return driver.findElement(navigation_Dashboard_By);
    }

    public WebElement getAddProjectButton() {
        return driver.findElement(add_Project_Button_By);
    }

    public WebElement getMostActiveTime() {
        return driver.findElement(most_Active_Time_By);
    }

    public WebElement selectTimeFrame() {
        return driver.findElement(select_Time_Frame_By);
    }

    public WebElement textInTimeFrame() {
        return driver.findElement(text_in_Time_Frame_By);
    }

    public WebElement getInProgressElement() {
        return driver.findElement(in_Progress_By);
    }

    public WebElement getChosenProject(String projectName) { return driver.findElement(By.xpath(choose_project_By.replace("replace", projectName))); }

    public String getDashboardButtonText() {
        return getDashboardButton().getText();
    }

    public void clickAddProjectButton() { getAddProjectButton().click(); }

}

