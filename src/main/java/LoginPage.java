import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;

    public LoginPage (WebDriver driver) {
        this.driver = driver;
    }

    private By registerButton = By.xpath(".//a[text() = 'Зарегистрироваться']");

    private By recoverButton = By.xpath(".//a[text() = 'Восстановить пароль']");

    private By loginButton = By.xpath(".//button[text() = 'Войти']");

    private By emailField = By.xpath(".//label[text()='Email']/../..//input[@name = 'name']");

    private By passwordField = By.xpath(".//input[@name = 'Пароль']");

    @Step ("Click on login button on Login page")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Click on register button on Login page")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    @Step("Checks if Login page displayed")
    public Boolean isLoginButtonDisplayed() {
        return driver.findElement(loginButton).isDisplayed();
    }

    @Step("Waits until page is loaded")
    public void waitForPageLoad() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(loginButton));
    }

    @Step("Fill user email to field Email on Login page")
    public void fillEmail(String text) {
        driver.findElement(emailField).sendKeys(text);
    }

    @Step("Fill user password to field Password on Login page")
    public void fillPassword(String text) {
        driver.findElement(passwordField).sendKeys(text);
    }

    @Step ("Click on recover button on Login page")
    public void clickRecoverButton() {
        driver.findElement(recoverButton).click();
    }
}
