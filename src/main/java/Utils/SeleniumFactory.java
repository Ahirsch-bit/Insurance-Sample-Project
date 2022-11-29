package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;


public class SeleniumFactory {

    private static final Map<String, WebDriver> drivers = new HashMap<>();

    public static WebDriver getDriver(){
        return getDriver("chrome");
    }

    public static WebDriver getDriver(String browser) {
        WebDriver driver=drivers.get(browser.toLowerCase());
        switch (browser.toLowerCase()){
            case "firefox":
                if (driver == null) {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    drivers.put("firefox", driver);
                }
                break;
            case "edge":
                if (driver == null) {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    drivers.put("edge", driver);
                }
                break;
            case "chrome":
                if (driver == null) {
                    ChromeOptions chromeOptions = new ChromeOptions();
                    if (System.getProperty("os.name").equals("Linux")){
                        chromeOptions.addArguments("enable-automation");
                        chromeOptions.addArguments("--headless");
                        chromeOptions.addArguments("--window-size=1920,1080");
                        chromeOptions.addArguments("--no-sandbox");
                        chromeOptions.addArguments("--disable-extensions");
                        chromeOptions.addArguments("--dns-prefetch-disable");
                        chromeOptions.addArguments("--disable-gpu");
                        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                    }
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(chromeOptions);
                    drivers.put("chrome", driver);
                }
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static void closeAllDriver() {
        drivers.keySet().forEach(driver->drivers.get(driver).quit());
    }
}
