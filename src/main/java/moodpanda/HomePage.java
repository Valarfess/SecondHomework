package moodpanda;

import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private static final String UPD_MOOD_BUTTON = "#LinkUpdate";
    private static final String MOOD_SLIDER = "#slider-range-min > a";
    private static final String CONFIRM_UPDATE = "#UpdateMood";

    public void updateMood(){
        $(UPD_MOOD_BUTTON).click();
        $(MOOD_SLIDER).click();
        $(MOOD_SLIDER).sendKeys(Keys.RIGHT);
        $(CONFIRM_UPDATE).click();
    }
}
