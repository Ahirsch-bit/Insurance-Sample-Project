package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DestinationPage extends BasePage{

    @FindBy(css = "[alt='USA']")
    private WebElement usa;
    @FindBy(css = "[alt='canada']")
    private WebElement canada;
    @FindBy(css = "[alt='africa']")
    private WebElement africa;
    @FindBy(css = "[alt='europe']")
    private WebElement europe;
    @FindBy(css = "[alt='asia']")
    private WebElement asia;
    @FindBy(css = "[alt='centerSouthAmerica']")
    private WebElement centerSouthAmerica;
    @FindBy(css = "[alt='australia']")
    private WebElement australia;

    public DestinationPage(WebDriver driver) {
        super(driver);
    }

//I prefer to use the "new" switch case format, however not everyone is using Java 14,
// so I prefer the backwards compatibility
    public void gotoContinent(String continent){
        switch (continent.toLowerCase()){
            case "usa":
                click(usa);
                break;
            case "canada":
                click(canada);
                break;
            case "africa":
                click(africa);
                break;
            case "europe":
                click(europe);
                break;
            case "asia":
                click(asia);
                break;
            case "centersouthamerica":
                click(centerSouthAmerica);
                break;
            case "australia":
                click(australia);
                break;
        }
    }
}
