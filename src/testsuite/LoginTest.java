package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";


    //  String baseUrl =  "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        //Type username
        sendTextToElements(By.name("user-name"), "standard_user");
        //type password
        sendTextToElements(By.name("password"), "secret_sauce");
        // click on Login tab

        clickOnElement(By.xpath("//input[@id='login-button']"));

        String expectMessage = "PRODUCTS";

        //Find the login button and click on it

        WebElement actualTextMessageElement = driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        String actualMessage = actualTextMessageElement.getText();


        //validate actual and expected message
        Assert.assertEquals("No such text passed", expectMessage, actualMessage);


    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {

        //Type username
        sendTextToElements(By.name("user-name"), "standard_user");
        //type password
        sendTextToElements(By.name("password"), "secret_sauce");
        // click on Login tab

        clickOnElement(By.xpath("//input[@id='login-button']"));

// verify six products displayed
    boolean isInventoryDisplayed = driver.findElement(By.id("inventory_container")).isDisplayed();
        System.out.println("All six items displayed:  "+ isInventoryDisplayed);

}
        @After
    public void tearDown() {
        closeBrowser();
    }
}
