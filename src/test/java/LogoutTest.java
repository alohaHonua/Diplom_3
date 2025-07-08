import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import user.User;
import user.UserAPI;

import static org.junit.Assert.assertTrue;

public class LogoutTest {
    @Rule
    public final BrowserRule browserRule = new BrowserRule();

    UserAPI userAPI = new UserAPI();
    User user = new User("watermelon@gmail.com","АРБУЗ","w1a2t3e4r5m6e7l8o9n");

    @Before
    public void createUser(){
        userAPI.createUserRequest(user);
    }

    @Test
    @DisplayName("Выход по кнопке <Выйти> в личном кабинете")
    public void logoutTest() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        LoginPage loginPage = new LoginPage(browserRule.getWebDriver());
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(browserRule.getWebDriver());
        mainPage.clickLoginButton();
        loginPage.waitForPageLoad();
        loginPage.fillEmail(user.getEmail());
        loginPage.fillPassword(user.getPassword());
        loginPage.clickLoginButton();
        personalAccountPage.waitForPageLoad();
        personalAccountPage.clickPersonalAccountButton();
        personalAccountPage.waitForLogoutButtonLoad();
        personalAccountPage.clickLogoutButton();
        loginPage.waitForPageLoad();
        assertTrue(loginPage.isLoginButtonDisplayed());
    }

    @After
    public void deleteUser() {
        userAPI.deleteUserRequest(user);
    }
}
