package core;

import java.io.IOException;
import java.util.Properties;

public final class ReadProperties {
    private static ReadProperties instance;
    protected static Properties properties;

    private ReadProperties() {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
            properties.load(getClass().getClassLoader().getResourceAsStream("testData.properties"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ReadProperties getInstance() {
        if (instance == null) {
            instance = new ReadProperties();
        }
        return instance;
    }

    public String getTestRailSite() {
        return properties.getProperty("testrailURL");
    }

    public String getLogin() {
        return properties.getProperty("login");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }

    public String getIncorrectLogin() {
        return properties.getProperty("incorrectLogin");
    }

    public String getIncorrectPassword() {
        return properties.getProperty("incorrectPassword");
    }

    public String getProjectName() {
        return properties.getProperty("projectName");
    }

    public String getAnnouncementMessage() {
        return properties.getProperty("announcementMessage");
    }

    public String getNameProject() {
        return properties.getProperty("nameProject");
    }

    public String getBrowserName() {
        return properties.getProperty("browser");
    }

    public boolean isHeadless() {
        return properties.getProperty("headless").equalsIgnoreCase("true");
    }

    public int getTimeOut() {
        return Integer.parseInt(properties.getProperty("timeout"));
    }
}
