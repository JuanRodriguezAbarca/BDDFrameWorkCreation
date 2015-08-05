package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Juan_Rodriguez on 6/30/2015.
 */
public class WebDriverClass {

    protected static final Logger LOG = LoggerFactory.getLogger(WebDriverClass.class);


    private static WebDriver driver;


    public static WebDriver getInstance() {
        if (driver == null) {
            try {

                WebDriverClass.driver = driverSelector();
                driver.manage().window().maximize();
            } finally {
                Runtime.getRuntime().addShutdownHook(
                        new Thread(new BrowserClearup()));
            }
        }
        return driver;

    }

    private static WebDriver driverSelector() {


        String driverType = System.getProperty("driver");
        if(driverType==null)
            driverType = "";

        LOG.info("Driver loading is " + driverType);

        switch (driverType) {

            case "firefox":
                return new FirefoxDriver();
            case "chrome":
                return new ChromeDriver();
            case "ie":
                WebDriver tempDriver = new InternetExplorerDriver();
                System.setProperty("webdriver.ie.driver.silent", "true");
                System.setProperty("webdriver.ie.driver.loglevel", "ERROR");
                return tempDriver;
            default:
                return new FirefoxDriver();

        }
    }


    private static class BrowserClearup implements Runnable {
        public void run() {
            LOG.info("Closing the browser...");
            close();
        }
    }


    public static void close() {
        try {
            getInstance().quit();
            driver = null;
            LOG.info("Closing the browser");
        } catch (UnreachableBrowserException e) {
            LOG.info("cannot close the browser: unreachable browser");
        }
    }


}


