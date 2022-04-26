package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

import java.util.ArrayList;
import java.util.List;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }


    public void selectMenu(String menu) {

        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]"));
    }

    @Test
    public void verifyPageNavigation() {
        List<String> topMenu = new ArrayList<>();
        topMenu.add("Computers");
        topMenu.add("Electronics");
        topMenu.add("Digital downloads");
        topMenu.add("Books");
        topMenu.add("Jewelry");
        topMenu.add("Gift Cards");

        for (int i = 0; i < topMenu.size(); i++) {

            selectMenu(topMenu.get(i));

            // Verification using a assert method
            String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'" + topMenu.get(i) + "')]"));
            Assert.assertEquals("Not on correct Page!!", topMenu.get(i), actualMessage);
            System.out.println("User is on Correct Page : " + topMenu.get(i));
        }
    }

    @After
    public void tearDown() {
        closeBrowser();


    }


}


