import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;

    public MainPage (WebDriver driver) {
        this.driver = driver;
    }

    private By loginButton = By.xpath(".//button[text() = 'Войти в аккаунт']");

    @Step ("Click on login button on Main page")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

}
