package Stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Step {
    WebDriver driver;
    @BeforeClass
    @Parameters({"browser","url"})
    void setup(String browser,String app) throws InterruptedException {

        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","src/main/resources/Drivers/chromedriver.exe");
            driver =new ChromeDriver();
            Thread.sleep(2000);
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver","src/main/resources/Drivers/geckodriver.exe");
            driver =new FirefoxDriver();
            Thread.sleep(2000);
            driver.manage().window().maximize();

        }

        else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "src/main/resources/msedegedriver.exe");
            WebDriver driver = new EdgeDriver();
            driver.manage().window().maximize();

        }
        driver.get(app);

    }


    @Given("launch page orangeHM {string} and {string}")
    public void launch_page_orange_hm_and(String browser, String app) {
             System.out.println("multiple browser");
    }

    @When("enter the username {string}")
    @Test
    @Parameters({"username"})
    public void enter_the_username(String string) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@placeholder='Username']")).click();
       driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(string);
    }
    @Test
    @When("password {string};")
    @Parameters({"password"})
    public void password(String string) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).click();
       driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
    }

    @Test
    @When("click button login")
    public void click_button_login() throws InterruptedException {
        Thread.sleep(3000);

        driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[3]/button[1]")).click();

    }
    @Test
    @Then("verify title")
    public void verify_title() throws InterruptedException {
        Thread.sleep(3000);
        String title=driver.getTitle();
        Assert.assertNotEquals(title,"orange");
    }
    @AfterClass
    @Then("close")
    public void close() throws InterruptedException {
   Thread.sleep(3000);
      driver.close();

    }
}
