package myaccounts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utilities;

import java.util.Random;

public class MyAccountsTest extends Utilities {

    String baseUrl = "http://tutorialsninja.com/demo/index.php";
    String email = "rio" + new Random().nextInt(100000) + "@example.com";

    @Before
    public void setUp(){

        openBrowser(baseUrl);
    }
    public void selectMyAccountOptions(String menu){
        String exp = String.format("//a[text()='%s']", menu) ;
        driver.findElement(By.xpath(exp)).click();
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){

        //2.1 Click on My Account Link
        clickOnElement(By.xpath("//span[text()='My Account']"));

        // 2.2 Call the method “selectMyAccountOptions”
        selectMyAccountOptions("Register");

        // 2.3 Verify the text “Register Account”
        verifyText(By.xpath("//h1[text()='Register Account']"), "Register Account");
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){

        // 3.1 Click on My Account Link
        clickOnElement(By.xpath("//span[text()='My Account']"));

        // 3.2 Call the method “selectMyAccountOptions”
        selectMyAccountOptions("Login");

        // 3.3 Verify the text “Register Account”
        verifyText(By.xpath("//h2[text()='Returning Customer']"), "Returning Customer");
    }
    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {

        // 3.1 Click on My Account Link
        clickOnElement(By.xpath("//span[text()='My Account']"));

        // 3.2 Call the method “selectMyAccountOptions”
        selectMyAccountOptions("Register");

        //3.3 Enter First Name

        sendTextToElement(By.id("input-firstname"), "Rax");
        sendTextToElement(By.id("input-lastname"),"Richardson");
        sendTextToElement(By.id("input-email"), email);
        sendTextToElement(By.id("input-telephone"), "8866300551");
        sendTextToElement(By.id("input-password"), "ri0201289");
        sendTextToElement(By.id("input-confirm"), "ri0201289");
        clickOnElement(By.name("newsletter"));
        clickOnElement(By.name("agree"));
        Thread.sleep(4000);
        clickOnElement(By.xpath("//input[@type='submit']"));
        verifyText(By.xpath("//h1[text()='Your Account Has Been Created!']"), "Your Account Has Been Created!");
        clickOnElement(By.xpath("//div[@class='pull-right']/a[text()='Continue']"));
        Thread.sleep(3000);
        //3.4 Click on My Account Link
        clickOnElement(By.xpath("//span[text()='My Account']"));
        selectMyAccountOptions("Logout");

        //3.5 Verify the text “Register Account”
        verifyText(By.xpath("//h1[text()='Account Logout']"), "Account Logout");
        clickOnElement(By.xpath("//div[@class='pull-right']/a[text()='Continue']"));

    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {

        //4.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[text()='My Account']"));

        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter Login”
        selectMyAccountOptions("Login");

        //4.3 Enter Email address
        sendTextToElement(By.id("input-email"),"pratik@gmail.com");

        //4.4 Enter Password
        sendTextToElement(By.id("input-password"),"rio201289");

        //4.5 Click on Login button
        clickOnElement(By.xpath("//input[@class='btn btn-primary']"));

        //4.6 verify text “My Account”
        Thread.sleep(3000);
        verifyText(By.xpath("//h2[text()='My Account']"),"My Account");

        //4.7 Click on My Account Link.
        clickOnElement(By.xpath("//span[text()='My Account']"));

        //4.8 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");

        // 4.9 Verify the text “Account Logout”
        verifyText(By.xpath("//h1[text()='Account Logout']"),"Account Logout");

        //4.10 Click on Continue button
        clickOnElement(By.xpath("//div[@class='pull-right']/a[text()='Continue']"));
    }


    @After
    public void teardown(){
        closeBrowser();
    }

}