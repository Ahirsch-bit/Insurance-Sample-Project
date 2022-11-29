package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TravelPolicyPage extends BasePage {

    @FindBy(xpath = "//*[@datahrlbo='purchase-for-new-customer']/span")
    private WebElement newCustomer;
    @FindBy(xpath = "//*[@datahrlbo='purchase-for-returning-customer']/span")
    private WebElement returningCustomer;

    public TravelPolicyPage(WebDriver driver) {
        super(driver);
    }

    public void chooseNewCustomer(){
        click(newCustomer);
    }

    public void chooseReturningCustomer(){
        click(returningCustomer);
    }
}
