package saucedemomodel;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SouceDemoTest extends Base {

    private static final String USERNAME = "standard_user";
    private static final String PASSWORD = "secret_sauce";


    @Test
    public void TestSauceDemo() {
        driver.get("https://www.saucedemo.com/");
//        loginPage.LoginSuccess(USERNAME, PASSWORD);
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
