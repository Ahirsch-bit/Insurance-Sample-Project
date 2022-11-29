package Tests;

import Actions.GetInsurance;
import Utils.SeleniumFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class E2ETest {

    @Test
    public void getInsurance(){
        GetInsurance getInsurance = new GetInsurance("https://digital.harel-group.co.il/travel-policy");
        getInsurance.completeRequest("usa",7,30);
    }

    @AfterTest
    public void teardown(){
        SeleniumFactory.closeAllDriver();
    }
}
