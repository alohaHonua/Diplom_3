import io.qameta.allure.junit4.DisplayName;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import user.User;
import user.UserAPI;

public class RegistrationTest {

    @Rule
    public final BrowserRule browserRule = new BrowserRule();

    private WebDriver driver;

    UserAPI userAPI = new UserAPI();
    User user = new User("avocado@gmail.com","АВОКАДО","123456");

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

    }

    @After
    public void deleteUser() {
            userAPI.deleteUserRequest(user);
    }

}
