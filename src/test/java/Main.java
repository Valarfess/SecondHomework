import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main extends Base {

    private static final String USERNAME = "standard_user";
    private static final String PASSWORD = "secret_sauce";

    @Test
    public void TestSauceDemo() {
        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.LoginSuccess(USERNAME,PASSWORD);
        String nameItemInShop = driver.findElementByXPath("//*[@id=\"item_1_title_link\"]/div").getText();
        String costItemInShop = driver.findElementByXPath("//*[@id=\"inventory_container\"]/div/div[3]/div[2]/div[2]/div").getText();
        driver.findElementByXPath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]").click();
        driver.findElementByXPath("//*[@id=\"shopping_cart_container\"]/a").click();
        String nameItemInCart = driver.findElementByXPath("//*[@id=\"item_1_title_link\"]/div").getText();
        String costItemInCart = driver.findElementByXPath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div").getText();
        Assert.assertEquals(nameItemInShop, nameItemInCart);
        Assert.assertEquals(costItemInShop, costItemInCart);
    }
}
