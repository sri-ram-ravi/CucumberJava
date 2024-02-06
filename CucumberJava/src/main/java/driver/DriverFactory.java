package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverFactory {
    static WebDriver driver = null;
    private static WebDriverWait wait;
    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (webDriverThreadLocal.get() == null) {
            webDriverThreadLocal.set(createDriver());
        }
        return webDriverThreadLocal.get();
    }

    private static WebDriver createDriver() {
        String browserType = "chrome";

        switch (browserType) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-headless");
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
                driver = new ChromeDriver(chromeOptions);
                break;
            }
            case "firefox" -> {
                WebDriverManager.chromedriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--start-headless");
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
                driver = new FirefoxDriver(firefoxOptions);
                driver.manage().window().maximize();
                wait = new WebDriverWait(driver, Duration.ofSeconds(20));
                break;
            }
            case "edge" -> {
                WebDriverManager.chromedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-headless");
                edgeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
                driver = new EdgeDriver(edgeOptions);
                driver.manage().window().maximize();
                wait = new WebDriverWait(driver, Duration.ofSeconds(20));
                break;
            }
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static void cleanUpDriver() {
        if (webDriverThreadLocal.get() != null) {
            webDriverThreadLocal.get().quit();
            webDriverThreadLocal.remove();
        }
    }
}
