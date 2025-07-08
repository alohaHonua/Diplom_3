import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import user.User;
import user.UserAPI;

import static org.junit.Assert.assertTrue;

public class RedirectTest {
    @Rule
    public final BrowserRule browserRule = new BrowserRule();

    UserAPI userAPI = new UserAPI();
    User user = new User("apple@gmail.com","ЯБЛОКО","a1p2p3l4e");

    @Before
    public void createUser(){
        userAPI.createUserRequest(user);
    }

    @Test
    @DisplayName("Переход по клику на <Личный кабинет>")
    public void redirectToUserProfileTest() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        LoginPage loginPage = new LoginPage(browserRule.getWebDriver());
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(browserRule.getWebDriver());
        mainPage.clickLoginButton();
        loginPage.fillEmail(user.getEmail());
        loginPage.fillPassword(user.getPassword());
        loginPage.clickLoginButton();
        personalAccountPage.clickPersonalAccountButton();
        assertTrue(personalAccountPage.checkProfileButton());
    }

    @Test
    @DisplayName("Переход по клику на <Конструктор>")
    public void redirectToConstructorTest() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        LoginPage loginPage = new LoginPage(browserRule.getWebDriver());
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(browserRule.getWebDriver());
        mainPage.clickLoginButton();
        loginPage.fillEmail(user.getEmail());
        loginPage.fillPassword(user.getPassword());
        loginPage.clickLoginButton();
        personalAccountPage.clickPersonalAccountButton();
        mainPage.clickConstructorButton();
        assertTrue(personalAccountPage.checkOrderButton());
    }

    @Test
    @DisplayName("Переход по клику на логотип")
    public void redirectToLogoTest() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        LoginPage loginPage = new LoginPage(browserRule.getWebDriver());
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(browserRule.getWebDriver());
        mainPage.clickLoginButton();
        loginPage.fillEmail(user.getEmail());
        loginPage.fillPassword(user.getPassword());
        loginPage.clickLoginButton();
        personalAccountPage.clickPersonalAccountButton();
        mainPage.clickLogoButton();
        assertTrue(personalAccountPage.checkOrderButton());
    }

    @After
    public void deleteUser() {
        userAPI.deleteUserRequest(user);
    }
}
