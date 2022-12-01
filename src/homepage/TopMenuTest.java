package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utilities;

public class TopMenuTest extends Utilities {

    String BaseUrl="http://tutorialsninja.com/demo/index.php";
    @Before
    public void setup(){
        openBrowser(BaseUrl);
    }
    public void selectMenu(String menu) {
        //String mainMenu = menu.toLowerCase();
        String exp=String.format("//a[text()='%s']",menu);
        driver.findElement(By.xpath(exp)).click();
    }
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {
     // mouseHoverToElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]]"));

        //1.1 Mouse hover on “Desktops” Tab and click
        selectMenu("Desktops");
        mouseHoverToElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));

        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu("Show All Desktops");

        //1.3 Verify the text ‘Desktops’
        String actualText = getTextFromElement(By.xpath("//h2[contains(text(),'Desktops')]"));
        String ExpectedText="Desktops";
        Assert.assertEquals("Not verified The Price",actualText,ExpectedText);
   }
   @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
       selectMenu("Laptops & Notebooks");
       mouseHoverToElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));

       //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
       selectMenu("Show All Laptops & Notebooks");

       //2.3 Verify the text ‘Laptops & Notebooks’
       String actualText = getTextFromElement(By.xpath("//h2[contains(text(),'Laptops & Notebooks')]"));
       String ExpectedText="Laptops & Notebooks";
       Assert.assertEquals("Not verified The Price",actualText,ExpectedText);

    }

   @Test
   public void verifyUserShouldNavigateToComponentsPageSuccessfully(){

        //3.1 Mouse hover on “Components” Tab and click
       selectMenu("Components");
       mouseHoverToElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[3]/a[1]"));

       //3.2 call selectMenu method and pass the menu = “Show All Components”
       selectMenu("Show All Components");

       //3.3 Verify the text ‘Components’
       //h2[contains(text(),'Components')]
       String actualText = getTextFromElement(By.xpath("//h2[contains(text(),'Components')]"));
       String ExpectedText="Components";
       Assert.assertEquals("Not verified The Price",actualText,ExpectedText);
   }

    @After
    public void tearDown(){
        closeBrowser();
    }

}
