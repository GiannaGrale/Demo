package baseEntities;


import cucumber_aqa06.support.MyWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;



public class BaseGUIStep {

    public final EventFiringWebDriver webDriver;

    public BaseGUIStep(MyWebDriver webDriver) {
        this.webDriver = webDriver;
    }

}
