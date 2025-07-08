import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage (WebDriver driver) {
        this.driver = driver;
    }

    private By registerButton = By.xpath(".//a[text() = 'Зарегистрироваться']");

    @Step("Click on register button on Login page")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }
}
