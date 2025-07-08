import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import user.User;
import user.UserAPI;

import static org.junit.Assert.assertTrue;

public class LoginTest {

    @Rule
    public final BrowserRule browserRule = new BrowserRule();

    UserAPI userAPI = new UserAPI();
    User user = new User("orange@gmail.com","АПЕЛЬСИН","o1r2a3n4g5e");

    @Before
    public void createUser(){
        userAPI.createUserRequest(user);
    }

    @Test
    @DisplayName("Вход по кнопке <Войти в аккаунт> на главной")
    public void loginUserByLoginButtonTest() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        LoginPage loginPage = new LoginPage(browserRule.getWebDriver());
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(browserRule.getWebDriver());
        mainPage.clickLoginButton();
        loginPage.waitForPageLoad();
        loginPage.fillEmail(user.getEmail());
        loginPage.fillPassword(user.getPassword());
        loginPage.clickLoginButton();
        personalAccountPage.waitForPageLoad();
        assertTrue(personalAccountPage.checkOrderButton());
    }

    @Test
    @DisplayName("Вход через кнопку <Личный кабинет>")
    public void loginUserByPersonalAccountButtonTest() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        LoginPage loginPage = new LoginPage(browserRule.getWebDriver());
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(browserRule.getWebDriver());
        mainPage.clickPersonalAccountButton();
        loginPage.waitForPageLoad();
        loginPage.fillEmail(user.getEmail());
        loginPage.fillPassword(user.getPassword());
        loginPage.clickLoginButton();
        personalAccountPage.waitForPageLoad();
        assertTrue(personalAccountPage.checkOrderButton());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginUserByButtonOnRegistrationFormTest() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        LoginPage loginPage = new LoginPage(browserRule.getWebDriver());
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(browserRule.getWebDriver());
        RegisterPage registerPage = new RegisterPage(browserRule.getWebDriver());
        mainPage.clickLoginButton();
        loginPage.clickRegisterButton();
        registerPage.clickLoginButton();
        loginPage.waitForPageLoad();
        loginPage.fillEmail(user.getEmail());
        loginPage.fillPassword(user.getPassword());
        loginPage.clickLoginButton();
        personalAccountPage.waitForPageLoad();
        assertTrue(personalAccountPage.checkOrderButton());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginUserByButtonOnRecoverPasswordFormTest() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        LoginPage loginPage = new LoginPage(browserRule.getWebDriver());
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(browserRule.getWebDriver());
        RecoverPasswordPage recoverPasswordPage = new RecoverPasswordPage(browserRule.getWebDriver());
        mainPage.clickLoginButton();
        loginPage.clickRecoverButton();
        recoverPasswordPage.clickLoginButton();
        loginPage.waitForPageLoad();
        loginPage.fillEmail(user.getEmail());
        loginPage.fillPassword(user.getPassword());
        loginPage.clickLoginButton();
        personalAccountPage.waitForPageLoad();
        assertTrue(personalAccountPage.checkOrderButton());
    }


    @After
    public void deleteUser() {
        userAPI.deleteUserRequest(user);
    }
}
