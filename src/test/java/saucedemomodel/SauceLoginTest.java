package saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import saucedemomodel.HomePage;
import saucedemomodel.LoginPage;

public class SauceLoginTest {

    private static final String USERNAME = "standard_user";
    private static final String PASSWORD = "secret_sauce";
    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Fess\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void login() {
        HomePage homePage = loginPage.loginSuccess(USERNAME, PASSWORD);
        WebElement cart = driver.findElement(homePage.getCartElement());
        Assert.assertTrue(cart.isDisplayed(), "You are not logged in");
    }

    @Test
    public void loginNegative() {
        WebElement error = loginPage.invalidLogin(USERNAME, "");
        Assert.assertTrue(error.isDisplayed(), "You are logged in");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }


}
