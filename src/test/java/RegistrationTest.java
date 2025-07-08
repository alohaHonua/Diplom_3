import io.qameta.allure.junit4.DisplayName;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import user.User;
import user.UserAPI;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegistrationTest {

    private final static String wrongPasswordMessage = "Некорректный пароль";

    @Rule
    public final BrowserRule browserRule = new BrowserRule();

   // private WebDriver driver;

    UserAPI userAPI = new UserAPI();
    User user = new User("avocado@gmail.com","АВОКАДО","a1v2o3c4a5d6o");
    User userIncorrectPassword = new User("avocado_password@gmail.com","АВОКАДО","12345");

    @Test
    @DisplayName("Успешная регистрация пользователя")
    public void registerUserSuccessfulTest() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        LoginPage loginPage = new LoginPage(browserRule.getWebDriver());
        RegisterPage registerPage = new RegisterPage(browserRule.getWebDriver());
        mainPage.clickLoginButton();
        loginPage.clickRegisterButton();
        registerPage.fillEmail(user.getEmail());
        registerPage.fillName(user.getName());
        registerPage.fillPassword(user.getPassword());
        registerPage.clickRegisterButton();
        loginPage.waitForPageLoad();
        assertTrue(loginPage.isLoginButtonDisplayed());
    }

    @Test
    @DisplayName("Ошибка при регистрации пользователя")
    public void registerUserUnsuccessfulTest() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        LoginPage loginPage = new LoginPage(browserRule.getWebDriver());
        RegisterPage registerPage = new RegisterPage(browserRule.getWebDriver());
        mainPage.clickLoginButton();
        loginPage.clickRegisterButton();
        registerPage.fillEmail(userIncorrectPassword.getEmail());
        registerPage.fillName(userIncorrectPassword.getName());
        registerPage.fillPassword(userIncorrectPassword.getPassword());
        registerPage.clickRegisterButton();
        String errorMessageActual = registerPage.getErrorText();
        assertEquals(wrongPasswordMessage, errorMessageActual);
    }

    @After
    public void deleteUser() {
            userAPI.deleteUserRequest(user);
    }

}
