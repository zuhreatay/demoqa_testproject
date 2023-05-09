package utilties.utilities;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver() {
    }

     static WebDriver driver;


    public static WebDriver getDriver() {

        if (driver == null) {
            switch (ConfigReader.getProperty("browser")) {
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "ie":
                    driver = new InternetExplorerDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                case "edge":
                    driver = new EdgeDriver();
                    break;
                default:
                    driver = new ChromeDriver();
            }
        }

      //  driver.manage().window().maximize();
        Dimension dim=new Dimension(2000,2500);
        driver.manage().window().setSize(dim);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));





        return driver;
    }

    public static void closeDriver() {

        if (driver != null) {
            // driver.quit();
            driver = null;
        }

    }


}
