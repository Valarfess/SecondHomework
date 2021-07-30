package moodpanda;

import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.open;


public class MoodPandaLoginTest extends BaseTest {

    public static final String EMAIL = "Valarfess@gmail.com";
    public static final String PASSWORD = "Valar211922";

    @Test
    public void loginTest() {
        open("login");
        LoginPage loginPage = new LoginPage();
        loginPage.login(EMAIL,PASSWORD);
    }

    @Test
    public void updateMood(){
        open("login");
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.login(EMAIL,PASSWORD);
    }

}
