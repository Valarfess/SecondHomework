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
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElementByXPath("//*[@id=\"content\"]/div/button").click();
        driver.findElementByXPath("//*[@id=\"content\"]/div/button").click();
        driver.findElementByXPath("//*[@id=\"elements\"]/button[2]").click();
        List<WebElement> element = driver.findElements(By.xpath("//*[@id=\"elements\"]/button"));
        Assert.assertEquals(element.size(), 1, "Все ок ;)");
    }

    @Test
    public void CheckBoxes() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> element = driver.findElements(By.cssSelector("[type=checkbox]"));
        if (element.get(0).getAttribute("checked") == null) {
            element.get(0).click();
        }
        if (element.get(1).getAttribute("checked") != null) {
            element.get(1).click();
        }
        Assert.assertTrue(true, "Ok");
    }

    @Test
    public void dropDown() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        Select dropDown = new Select(driver.findElement(By.id("dropdown")));
        dropDown.selectByValue("1");
        String nameFirstElement = dropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(nameFirstElement,"Option 1", "Not select");
        dropDown.selectByValue("2");
        String nameSecondElement = dropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(nameSecondElement,"Option 2", "Not select");
    }

    @Test
    public void inputs() {
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement element = driver.findElementByTagName("input");
        element.click();
        element.clear();
        element.sendKeys("0");
        for (int i = 0; i <= 100; i++) {
            element.sendKeys(Keys.ARROW_UP);
        }
        element.clear();
        element.sendKeys("0");
        for (int i = 0; i >= -100; i--) {
            element.sendKeys(Keys.ARROW_DOWN);
        }
        element.clear();
        ArrayList<Character> abc = new ArrayList<>();
        for (char i = 'a'; i <= 'z'; i++) {
            abc.add(i);
        }
//        element.sendKeys("abc");
////        for (Character i:abc) {
////            element.sendKeys(i);
//        Assert.assertEquals(element.getText().getBytes(),"abc");
    }


    @Test
    public void dataTables() {
        driver.get("http://the-internet.herokuapp.com/tables");
        WebElement element = driver.findElementByXPath("//table//tr[1]//td[1]");
        Assert.assertEquals("Smith", "Smith");
        WebElement element2 = driver.findElementByXPath("//table//tr[2]//td[2]");
        Assert.assertEquals("Frank", "Frank");
        WebElement element3 = driver.findElementByXPath("//*[@id=\"table2\"]/tbody/tr[3]/td[3]");
        Assert.assertEquals("jdoe@hotmail.com", "jdoe@hotmail.com");
    }

    @Test
    public void typos() {
        driver.get("http://the-internet.herokuapp.com/typos");
        WebElement element = driver.findElementByXPath("//*[@id=\"content\"]/div/p[2]");
        Assert.assertEquals(element.getText(), "Sometimes you'll see a typo, other times you won't.");
    }

    @Test
    public void hovers() {
        driver.get("http://the-internet.herokuapp.com/hovers");

        Actions action = new Actions(driver);
        WebElement element1 = driver.findElementByXPath("//*[@id=\"content\"]/div/div[1]/img");
        action.moveToElement(element1).moveToElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"))).click().build().perform();
        WebElement elementName = driver.findElementByXPath("//*[@id=\"content\"]/div/div[1]/div/h5");
        Assert.assertEquals(elementName.getText(), "name: user1");
        WebElement elementUrlClick = driver.findElementByXPath("//*[@id=\"content\"]/div/div[1]/div/a");
        elementUrlClick.click();
        WebElement element404 = driver.findElementByXPath("/html/body/h1");
        Assert.assertEquals(element404.getText(), "Not Found");
        driver.navigate().back();

        Actions action2 = new Actions(driver);
        WebElement element2 = driver.findElementByXPath("//*[@id=\"content\"]/div/div[2]/img");
        action2.moveToElement(element2).moveToElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/img"))).click().build().perform();
        WebElement elementName2 = driver.findElementByXPath("//*[@id=\"content\"]/div/div[2]/div/h5");
        Assert.assertEquals(elementName2.getText(), "name: user2");
        WebElement elementUrlClick2 = driver.findElementByXPath("//*[@id=\"content\"]/div/div[2]/div/a");
        elementUrlClick2.click();
        WebElement element404second = driver.findElementByXPath("/html/body/h1");
        Assert.assertEquals(element404second.getText(), "Not Found");
        driver.navigate().back();

        Actions action3 = new Actions(driver);
        WebElement element3 = driver.findElementByXPath("//*[@id=\"content\"]/div/div[3]/img");
        action3.moveToElement(element3).moveToElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/img"))).click().build().perform();
        WebElement elementName3 = driver.findElementByXPath("//*[@id=\"content\"]/div/div[3]/div/h5");
        Assert.assertEquals(elementName3.getText(), "name: user3");
        WebElement elementUrlClick3 = driver.findElementByXPath("//*[@id=\"content\"]/div/div[3]/div/a");
        elementUrlClick3.click();
        WebElement element404third = driver.findElementByXPath("/html/body/h1");
        Assert.assertEquals(element404third.getText(), "Not Found");
    }

    @Test
    public void notification() {
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
        WebElement element = driver.findElementByXPath("//*[@id=\"content\"]/div/p/a");
        element.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement el = driver.findElementByXPath("//*[@id=\"flash\"]");
        Assert.assertEquals(el.getText(), "Action successful\n" + "×");
    }

}
