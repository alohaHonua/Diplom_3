import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

    private WebDriver driver;

    public RegisterPage (WebDriver driver) {
        this.driver = driver;
    }

    private By nameField = By.xpath(".//label[text()='Имя']/../..//input[@name = 'name']");

    private By emailField = By.xpath(".//label[text()='Email']/../..//input[@name = 'name']");

    private By passwordField = By.xpath(".//input[@name = 'Пароль']");

    private By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");

    private By errorMessage = By.xpath(".//p[contains(@class, 'error')]");

    private By loginButton = By.xpath(".//a[text()='Войти']");

    @Step("Click on register button on Register page")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    @Step("Click on login button on Register page")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Fill user name to field Name on Register page")
    public void fillName(String text) {
        driver.findElement(nameField).sendKeys(text);
    }

    @Step("Fill user email to field Email on Register page")
    public void fillEmail(String text) {
        driver.findElement(emailField).sendKeys(text);
    }

    @Step("Fill user password to field Password on Register page")
    public void fillPassword(String text) {
        driver.findElement(passwordField).sendKeys(text);
    }

    @Step("Get error message on Register page")
    public String getErrorText() {
        return driver.findElement(errorMessage).getText();
    }


}
