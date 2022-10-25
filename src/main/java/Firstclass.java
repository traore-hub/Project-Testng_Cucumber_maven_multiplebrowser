import com.microsoft.edge.seleniumtools.EdgeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Firstclass {

WebDriver driver;
    @BeforeClass
    @Parameters({"browser","url"})
    void setup(String browser,String app){

        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","src/main/resources/Drivers/chromedriver.exe");
            driver =new ChromeDriver();
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver","src/main/resources/Drivers/geckodriver.exe");
            driver =new FirefoxDriver();
            driver.manage().window().maximize();
            
        }

        else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "src/main/resources/msedegedriver.exe");
            WebDriver driver = new EdgeDriver();
            driver.manage().window().maximize();

        }
        driver.get(app);

    }
    @AfterMethod
    void after(){
        System.out.println("apres");
    }

    @Test(priority = 3)
    void login(){
        System.out.println("tres bien joué felicitations");  }
   @AfterClass
    void teardown() throws InterruptedException {


        Thread.sleep(2000);
        driver.quit();
    }

}
