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

    @Test
    public void AddRemoveElement() {
        driver.get("https://www.saucedemo.com/");
        driver.findElementByXPath("//*[@id=\"user-name\"]").sendKeys("standard_user");
        driver.findElementByXPath("//*[@id=\"password\"]").sendKeys("secret_sauce");
        driver.findElementByXPath("//*[@id=\"login-button\"]").click();
        driver.findElementById("react-burger-menu-btn");
        driver.findElementByName("add-to-cart-sauce-labs-backpack");
        driver.findElementByClassName("inventory_item_name");
        driver.findElementByTagName("button");
        driver.findElementByLinkText("LinkedIn");
        driver.findElement(By.xpath("//button[contains(@name,'products')]"));
        driver.findElement(By.xpath("//button[contains(text(),'cart')]"));
        driver.findElement(By.xpath("//button[contains(text(),'cart')]"));

    }
}
