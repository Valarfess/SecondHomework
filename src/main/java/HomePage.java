import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    private static By CART = By.id("shoping_cart_conteiner");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
}
