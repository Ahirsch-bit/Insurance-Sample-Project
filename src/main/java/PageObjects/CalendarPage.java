package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CalendarPage extends BasePage {

    @FindBy(xpath = "//*[@class='MuiPickersCalendar-week']//button[@data-hrl-bo and not(@disabled)]")
    private List<WebElement> availableDates;
    @FindBy(xpath = "(//*[@data-hrl-bo='arrow-forward'])[2]")
    private WebElement forwardArrow;
    @FindBy(css = "[data-hrl-bo='wizard-next-button']")
    private WebElement nextButton;
    @FindBy(css = "[data-hrl-bo='total-days']")
    private WebElement totalDays;
    private int startDay;

    public CalendarPage(WebDriver driver) {
        super(driver);
    }

    public CalendarPage chooseStartDate(int days) {
        this.startDay = days;
        click(daysAhead(days));
        return this;
    }

    public CalendarPage chooseEndDate(int daysFromStart) {
        click(daysAhead(daysFromStart + startDay-1));
        return this;
    }

    public CalendarPage clickNext() {
        click(nextButton);
        return this;
    }

    public int daysTotal() {
        return Integer.parseInt(getText(totalDays).replaceAll("[^0-9]", ""));
    }

    private WebElement daysAhead(int days) {
        int availableDays = availableDates.size();
        if (days < availableDays) {
            return availableDates.get(days);
        }
        click(forwardArrow);
        return availableDates.get(days);
    }
}
