package desktops;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utilities;

public class DesktopsTest extends Utilities {

    String BaseUrl="http://tutorialsninja.com/demo/index.php";
    @Before
    public void setup(){
        openBrowser(BaseUrl);
    }
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder(){

        //1.1 Mouse hover on Desktops Tab.and click
        mouseHoverToElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        //1.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Desktops')]"));
        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"),"Name (Z - A)");
        //1.4 Verify the Product will arrange in Descending order.
        verifyText(By.xpath("//option[contains(text(),'Name (Z - A)')]"), "Name (Z - A)");

    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        // 2.1 Mouse hover on Desktops Tab.and click
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));

        //2.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[(text() = 'Show All Desktops')]"));

        //2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (A - Z)");

        //2.4 Select product “HP LP3065”
        clickOnElement(By.xpath("//a[contains(text(),'HP LP3065')]"));

        //2.5 Verify the Text "HP LP3065"
        verifyText(By.xpath("//h1[contains(text(),'HP LP3065')]"), "HP LP3065");

        //2.6 Select Delivery Date "2022-11-30"
        selectDate("2022","November","30");

        //2.7 Enter Qty "1” using Select class.
        Thread.sleep(4000);
        driver.findElement(By.id("input-quantity")).clear();
        sendTextToElement(By.id("input-quantity"), "1");

        //2.8 Click on “Add to Cart” button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //2.9 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//span[@id='cart-total']"));

        //2.10 Verify the Product name "HP LP3065"
        verifyText(By.xpath("//tbody/tr[1]/td[2]/a[1]"), "HP LP3065");

        //Verify the Delivery Date "2022-11-30"
        String shipping_date = driver.findElement(By.xpath("//div[@class='input-group date']/input")).getAttribute("value");
        Assert.assertEquals(shipping_date, "2022-11-30");

        //Verify the Model "Product21"
        verifyText(By.xpath("//li[contains(text(),'Product Code: Product 21')]"), "Product Code: Product 21");

        //Verify the Todat "£74.73" = $122.00
        verifyText(By.xpath("//body[1]/header[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]"), "$122.00");

    }
    public void tearDown(){
        closeBrowser();
    }

}
