import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoverPasswordPage {

    private WebDriver driver;

    public RecoverPasswordPage (WebDriver driver) {
        this.driver = driver;
    }

    private By loginButton = By.xpath(".//a[text()='Войти']");

    @Step("Click on login button on Register page")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

}
