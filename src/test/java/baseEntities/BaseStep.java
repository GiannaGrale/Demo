package baseEntities;

import org.openqa.selenium.WebDriver;
import pages.*;
import utils.Waits;

public class BaseStep {
    protected WebDriver driver;
    protected Waits wait;

    public BaseStep(WebDriver driver) {
        this.driver = driver;
        this.wait = new Waits(driver, 20);
    }

    public LoginPage getLoginPage() {
        return new LoginPage(driver, false);
    }

    public ProjectPage getProjectPage() {
        return new ProjectPage(driver, false);
    }

    public DashboardPage getDashboardPage() {
        return new DashboardPage(driver, false);
    }

    public CasePage getCasePage() {
        return new CasePage(driver, false);
    }

    public AdminOverviewPage getAdminOverviewPage() {
        return new AdminOverviewPage(driver, false);
    }

    public CasesOverviewPage getCaseOverviewPage() {
        return new CasesOverviewPage(driver, false);
    }
}