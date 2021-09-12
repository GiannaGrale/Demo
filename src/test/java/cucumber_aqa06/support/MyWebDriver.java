package cucumber_aqa06.support;

import core.BrowserService;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class MyWebDriver extends EventFiringWebDriver {

    public MyWebDriver() {
        super(new BrowserService().getDriver());
    }
}
