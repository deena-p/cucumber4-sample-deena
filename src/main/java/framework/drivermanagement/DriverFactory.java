package framework.drivermanagement;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriverFactory {
    private static List<WebDriverThread> webDriverThreadPool = Collections.synchronizedList(new ArrayList<WebDriverThread>());
    private static ThreadLocal<WebDriverThread>  driverThread;

    @BeforeSuite
    public static void instantiateDriverObject(){
        driverThread = new ThreadLocal<WebDriverThread>(){
            @Override
            protected WebDriverThread initialValue() {
                WebDriverThread webDriverThread = new WebDriverThread();
                webDriverThreadPool.add(webDriverThread);
                return webDriverThread;
            }
        };
    }

    public static WebDriver getDriver(){
        return driverThread.get().getAWebDriver();
    }

    @AfterMethod
    public void clearCookies(){
        getDriver().manage().deleteAllCookies();
    }

    @AfterSuite
    public static void closeAllDriverObjects(){
        for(WebDriverThread driverThread:webDriverThreadPool){
            driverThread.quitWebDriver();
        }
    }
}
