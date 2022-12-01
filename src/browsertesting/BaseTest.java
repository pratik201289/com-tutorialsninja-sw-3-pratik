package browserTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public void openBrowser(String baseUrl){

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");  //1 param key // 2 param values
        driver = new ChromeDriver();
        //launch the URL
        driver.get(baseUrl);
        //maximize the windows
        driver.manage().window().maximize();
        //we give implicit time to deliver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    public void closeBrowser(){
        //close the browser
        driver.close();
    }
}
