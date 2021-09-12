package baseEntities;

import core.ReadProperties;
import org.openqa.selenium.WebDriver;
import utils.Waits;

public abstract class BasePage {
    protected WebDriver driver;
    protected static int waitForPageLoadingSec = 15;
    protected ReadProperties properties;
    protected Waits waits;

    protected abstract void openPage();

    public abstract boolean isPageOpened();


    public BasePage(WebDriver driver, boolean openPageByURL) {
        this.driver = driver;
        properties = ReadProperties.getInstance();
        this.waits = new Waits(driver, ReadProperties.getInstance().getTimeOut());

        if (openPageByURL) {
            openPage();
        }
        waitForOpen();
    }

    protected void waitForOpen() {
        int secondsCount = 0;

        boolean isPageOpenedIndicator = isPageOpened();

        while (!isPageOpenedIndicator && secondsCount < waitForPageLoadingSec) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            secondsCount++;
            isPageOpenedIndicator = isPageOpened();
        }

        if (!isPageOpenedIndicator) {
            throw new AssertionError("Page was not opened");
        }

    }
}