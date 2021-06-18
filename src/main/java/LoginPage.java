import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    private static By USERNAME_INPUT = By.id("user-name");
    private static By PASSWORD_INPUT = By.id("password");
    private static By LOGIN_BTN = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage LoginSuccess(String username,String password) {
        driver.findElement(USERNAME_INPUT).click();
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).click();
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BTN).click();
        return new HomePage(driver);
    }
}
