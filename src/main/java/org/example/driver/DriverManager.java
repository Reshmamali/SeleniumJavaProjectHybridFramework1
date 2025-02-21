package org.example.driver;

import org.example.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {
    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }

    public static void init() {
        // Setting our browser as null
        String browser = null;

        // We are getting the browser value from the
        // config.properties file and based on this value we will initialize the driver
        browser = PropertyReader.readKey("browser");

        // converting the browser value to lowercase so that there will be no confusion.
        browser = browser.toLowerCase();

        if (driver == null) {
            switch (browser) {
                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--start-maximized");
                    options.addArguments("--guest");
                    driver = new ChromeDriver(options);
                    break;
                case "edge":
                    EdgeOptions options1 = new EdgeOptions();
                    options1.addArguments("--start-maximized");
                    options1.addArguments("--guest");
                    driver = new EdgeDriver(options1);
                    break;
                case "firefox":
                    FirefoxOptions options2 = new FirefoxOptions();
                    options2.addArguments("--start-maximized");
                    options2.addArguments("--guest");
                    driver = new FirefoxDriver(options2);
                    break;
                default:
                    System.out.println("Browser not found");
            }
        }
    }

    public static void down() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
