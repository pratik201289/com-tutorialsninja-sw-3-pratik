package laptopsandnotebooks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utilities;

public class LaptopsAndNotebooksTest extends Utilities {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {

        // 1.1 Mouse hover on Laptops & Notebooks Tab and click
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));

        // 1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));

        // 1.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");

        //1.4 Verify the Product price will arrange in High to Low order.
        verifyText(By.xpath("//option[contains(text(),'Price (High > Low)')]"), "Price (High > Low)");
    }
    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException{

        Thread.sleep(1000);

        // 2.1 Mouse hover on Laptops & Notebooks Tab and click
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));

        // 2.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));

        // 2.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");

        //2.4 Select Product “MacBook”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//body/div[@id='product-category']/div[1]/div[1]/div[4]/div[4]/div[1]/div[2]/div[1]/h4[1]/a[1]"));

        //2.5 Verify the text “MacBook”
        verifyText(By.xpath("//h1[contains(text(),'MacBook')]"),"MacBook");

        //2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        String expectedText ="Success: You have added MacBook to your shopping cart!\n"+"×";
        String actualText = getTextFromElement(By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible"));
        Assert.assertEquals("Invalid text",expectedText,actualText);

        // 2.8  Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

        //2.9 Verify the text "Shopping Cart"
        verifyText(By.xpath("//h1[contains(text(),'(0.00kg)')]"),"Shopping Cart  (0.00kg)");

        // 2.10 Verify the Product name "MacBook"
        verifyText(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"),"MacBook");

        // 2.11 Change Quantity "2"
        driver.findElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]")).clear();
        sendTextToElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"),"2");

        // 2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/span[1]/button[1]/i[1]"));

        // 2.13 Verify the message “Success: You have modified your shopping cart!”
        String expectedshopText ="Success: You have added MacBook to your shopping cart!\n"+"×";
        String actualshopText = getTextFromElement(By.xpath("//body/div[@id='checkout-cart']/div[1]"));
        Assert.assertEquals("Invalid text",expectedText,actualText);

        // 2.14 Verify the Total £737.45
        verifyText(By.xpath("//tbody/tr[1]/td[6]"),"$1,204.00");

        // 2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));

        // 2.16 Verify the text “Checkout”
        verifyText(By.xpath("//h1[contains(text(),'Checkout')]"),"Checkout");

        // 2.17 Verify the Text “New Customer”
        Thread.sleep(2000);
        verifyText(By.xpath("//div/h2[contains(text(),'New Customer')]"),"New Customer");

        // 2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//div[1]/div[2]/label[1]/input[1]"));

        // 2.19 Click on “Continue” tab
        clickOnElement(By.id("button-account"));

        // 2.20 Fill the mandatory fields
        Thread.sleep(2000);
        sendTextToElement(By.id("input-payment-firstname"),"Kane");
        sendTextToElement(By.id("input-payment-lastname"),"Wilson");
        sendTextToElement(By.id("input-payment-email"),"Kanny@example.com");
        sendTextToElement(By.id("input-payment-telephone"),"8866300550");
        sendTextToElement(By.id("input-payment-address-1"),"Wall Street");
        sendTextToElement(By.id("input-payment-city"),"Wellington");
        sendTextToElement(By.id("input-payment-postcode"),"W11234");
        selectByValueFromDropDown(By.xpath("//select[@id='input-payment-country']"),"153");
        selectByValueFromDropDown(By.xpath("//select[@id='input-payment-zone']"),"2359");

        // 2.21 Click on “Continue” Button
        clickOnElement(By.id("button-guest"));

        // 2..22 Add Comments About your order into text area
        sendTextToElement(By.xpath("//div[1]/p[2]/textarea[1]"),"Not available");

        //Check the Terms & Conditions check box
        Thread.sleep(2000);
        clickOnElement(By.name("agree"));

        //Click on “Continue” button
        clickOnElement(By.id("button-payment-method"));

        //Verify the message “Warning: Payment method required!”
        String expectedWarningText = "Warning: Payment method required!\n" + "×";
        String actualWarningText = getTextFromElement(By.xpath("//div[@class='alert alert-danger alert-dismissible'][text()='Warning: Payment method required!']"));
        Assert.assertEquals("Warning message is not matched",expectedWarningText,actualWarningText);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}