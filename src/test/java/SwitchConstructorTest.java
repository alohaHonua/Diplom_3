import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SwitchConstructorTest {

    @Rule
    public final BrowserRule browserRule = new BrowserRule();

    @Test
    @DisplayName("Переход к разделу <Булки> в конструкторе")
    public void switchToBunsTest() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        mainPage.clickSauceButton();
        mainPage.clickBunsButton();
        mainPage.waitForElementsToLoad();
        assertEquals("Булки",mainPage.getActiveTabName());
    }

    @Test
    @DisplayName("Переход к разделу <Соусы> в конструкторе")
    public void switchToSauceTest() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        mainPage.clickSauceButton();
        mainPage.waitForElementsToLoad();
        assertEquals("Соусы",mainPage.getActiveTabName());
    }

    @Test
    @DisplayName("Переход к разделу <Начинки> в конструкторе")
    public void switchToFillingsTest() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        mainPage.clickFillingButton();
        mainPage.waitForElementsToLoad();
        assertEquals("Начинки",mainPage.getActiveTabName());
    }


}
