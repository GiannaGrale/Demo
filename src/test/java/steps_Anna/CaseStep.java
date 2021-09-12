package steps_Anna;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CasePage;
import pages.CasesOverviewPage;
import pages.DashboardPage;
import pages.ProjectOverviewPage;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class CaseStep extends BaseStep {

    public CaseStep(WebDriver driver) {
        super(driver);
    }

    @Step("Add a test case to the project '{projectName}'")
    public CaseStep addTestCaseWithFile(String projectName) throws InterruptedException, AWTException {
        DashboardPage dashboardPage = new DashboardPage(driver, true);
        dashboardPage.getChosenProject(projectName).click();
        ProjectOverviewPage projectOverViewPage = new ProjectOverviewPage(driver, false);
        projectOverViewPage.getTestCaseADDButton().click();
        CasePage casePage = new CasePage(driver, false);
        casePage.getTestCaseTitle().sendKeys("Add a file");

        wait.waitForVisibility(By.id("entityAttachmentListEmptyIcon")).click();
        wait.waitForVisibility(By.id("libraryAttachmentsAddItem")).click();

        Thread.sleep(3000);
        StringSelection stringSelection = new StringSelection(getFile());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        WebDriverWait webDriverWait = new WebDriverWait(driver, 20);
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(casePage.deleteAttachment(), "Delete"));
        WebElement attachElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("attachmentNewSubmit")));
        attachElement.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", casePage.getTestCaseADD());
        casePage.getTestCaseADD().click();
        CasesOverviewPage casesOverviewPage = new CasesOverviewPage(driver, false);
        return this;
    }

    String getFile() {
        return new File("Man-Silhouette.jpg").getAbsolutePath();
    }
}

