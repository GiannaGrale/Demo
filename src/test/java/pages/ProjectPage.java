package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectPage extends BasePage {


    private final static String endpoint = "index.php?/admin/projects/add";
    private final static By name_Input_By = By.id("name");
    private final static By announcement_Message_By = By.id("show_announcement");
    private final static By input_Announcement_By = By.xpath("//textarea[@id='announcement']");
    private final static By add_Project_Button_By = By.id("accept");
    private final static By successfully_delete_By = By.cssSelector(".message-success");
    private final static String delete_Project_Button_By = "//tr/td/a[contains(text(),'replace')]/following::div[3]";
    private final static By delete_Confirmation_Window_By = By.xpath("//div[@class='icon-progress-inline']/following::input");
    private final static By delete_Confirmation_Button_By = By.xpath("//div[@class='icon-progress-inline']/following::a[1]");

    public ProjectPage(WebDriver driver, boolean openPageByURL) {
        super(driver, openPageByURL);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getTestRailSite() + endpoint);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getAnnouncement_Message_Element().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public WebElement getProjectNameInput() {
        return driver.findElement(name_Input_By);
    }

    public WebElement getAnnouncementInput() {
        return driver.findElement(input_Announcement_By);
    }

    public WebElement getAnnouncement_Message_Element() {
        return driver.findElement(announcement_Message_By);
    }

    public WebElement getAddProjectButton() {
        return driver.findElement(add_Project_Button_By);
    }



    //Метод на ввод имени проекта
    public WebElement getNameInput (){return driver.findElement(name_Input_By);}
    public void setNameInput(String text) {  getNameInput().sendKeys(text);
    }

    //Метод на добавление проекта
    public WebElement getAddProject (){return driver.findElement(add_Project_Button_By);}
    public void clickAddProject (){ getAddProject().click();}

    //Методы на удаление проекта по выбранному имени
    public WebElement getDeleteProjectButton(String projectName) {
        return driver.findElement(By.xpath(delete_Project_Button_By.replace("replace", projectName)));
    }
    public void deleteProject(String projectName){
        getDeleteProjectButton(projectName).click();
    }

    public WebElement getDeleteConfirmationWindow() {
        return driver.findElement(delete_Confirmation_Window_By);
    }

    public WebElement getDeleteConfirmationButton() {
        return driver.findElement(delete_Confirmation_Button_By);
    }

    //Методы для проверки удаления проекта
    public WebElement getSuccessDelete(){ return driver.findElement(successfully_delete_By);}
}


