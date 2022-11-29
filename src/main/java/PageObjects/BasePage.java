package PageObjects;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter@Setter
public class BasePage {
    private WebDriver driver;
    private int timeout;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.timeout = 10;
        PageFactory.initElements(driver, this);
    }

    public void waitForElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void enterText(WebElement element,String text) {
        waitForElement(element);
        element.clear();
        element.sendKeys(text);
    }

    public void click(WebElement element) {
        waitForElement(element);
        element.click();
    }

    public String getText(WebElement element) {
        waitForElement(element);
        return element.getText();
    }

}
