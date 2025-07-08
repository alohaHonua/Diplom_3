import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private WebDriver driver;

    public RegisterPage (WebDriver driver) {
        this.driver = driver;
    }

    private By nameField = By.xpath(".//label[text()='Имя']/../..//input[@name = 'name']");

    private By emailField = By.xpath(".//label[text()='Email']/../..//input[@name = 'name']");

    private By passwordField = By.xpath(".//input[@name = 'Пароль']");

    private By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");

    @Step("Click on register button on Register page")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
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

}
