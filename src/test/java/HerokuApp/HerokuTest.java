package HerokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

public class HerokuTest {

    WebDriver driver;

    private static final String ALERT_TEXT = "You selected a context menu";

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Fess\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void getAlertTextTest() {
        driver.get("http://the-internet.herokuapp.com/context_menu");
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.id("hot-spot"))).contextClick().build().perform();
        String alertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        Assert.assertTrue(driver.findElement(By.id("content")).isDisplayed(), "Alert is still opened");
        Assert.assertEquals(alertText, ALERT_TEXT, "ok");
    }

    @AfterMethod
    public void exit() {
        driver.quit();
    }

    @Test
    public void dynamicControlTest(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        Assert.assertTrue(driver.findElement(By.cssSelector("input[type='checkbox']")).isDisplayed(), "No checkbox");

    }
}


