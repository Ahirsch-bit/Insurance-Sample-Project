package Actions;

import PageObjects.CalendarPage;
import PageObjects.DestinationPage;
import PageObjects.TravelPolicyPage;
import Utils.SeleniumFactory;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class GetInsurance {

    private final TravelPolicyPage travelPolicyPage;
    private final DestinationPage destinationPage;
    private final CalendarPage calendarPage;
    private final WebDriver driver;
    private final SoftAssert softAssert = new SoftAssert();



    public GetInsurance(String url) {
        this.driver = SeleniumFactory.getDriver();
        driver.get(url);
        this.travelPolicyPage = new TravelPolicyPage(driver);
        this.destinationPage = new DestinationPage(driver);
        this.calendarPage = new CalendarPage(driver);
    }

    public void completeRequest(String continent, int startDaysAhead, int lengthOfStay){
        travelPolicyPage.chooseNewCustomer();
        destinationPage.gotoContinent(continent);
        int totalDays = calendarPage.chooseStartDate(startDaysAhead)
                .chooseEndDate(lengthOfStay)
                .daysTotal();
        softAssert.assertEquals(totalDays,lengthOfStay);
        calendarPage.clickNext();
        String url = driver.getCurrentUrl();
        softAssert.assertEquals(url,"https://digital.harel-group.co.il/travel-policy/wizard/travelers");
        softAssert.assertAll();

    }
}
