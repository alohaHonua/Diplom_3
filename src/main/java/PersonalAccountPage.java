import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage {

    private WebDriver driver;

    public PersonalAccountPage (WebDriver driver) {
        this.driver = driver;
    }

    private By orderButton = By.xpath(".//button[text() = 'Оформить заказ']");

    private By personalAccountButton = By.xpath(".//p[text() = 'Личный Кабинет']");

    private By profileButton = By.xpath(".//a[text() = 'Профиль']");

    private By logoutButton = By.xpath(".//button[text() = 'Выход']");

    @Step("Check if order button exists on page")
    public Boolean checkOrderButton() {
       return driver.findElement(orderButton).isDisplayed();
    }

    @Step("Click on personal account button on Personal Account page")
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    @Step("Check if profile button exists on page")
    public Boolean checkProfileButton() {
        return driver.findElement(profileButton).isDisplayed();
    }

    @Step("Click logout button on Personal Account page")
    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }
}
