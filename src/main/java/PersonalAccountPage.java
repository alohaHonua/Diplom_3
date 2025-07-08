import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccountPage {

    private WebDriver driver;

    public PersonalAccountPage (WebDriver driver) {
        this.driver = driver;
    }

    private By orderButton = By.xpath(".//button[text() = 'Оформить заказ']");

    private By personalAccountButton = By.xpath(".//p[text() = 'Личный Кабинет']");

    private By profileButton = By.xpath(".//a[text() = 'Профиль']");

    private By logoutButton = By.xpath(".//button[text() = 'Выход']");

    @Step("Click on order button on Personal Account page")
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    @Step("Check if order button exists on page")
    public Boolean checkOrderButton() {
       return driver.findElement(orderButton).isDisplayed();
    }

    @Step("Waits until page is loaded")
    public void waitForPageLoad() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(orderButton));
    }

    @Step("Click on personal account button on Personal Account page")
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    @Step("Check if profile button exists on page")
    public Boolean checkProfileButton() {
        return driver.findElement(profileButton).isDisplayed();
    }

    @Step("Waits until element <Профиль> is loaded")
    public void waitForProfileLoad() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(profileButton));
    }

    @Step("Waits until element <Выход> is loaded")
    public void waitForLogoutButtonLoad() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
    }

    @Step("Click logout button on Personal Account page")
    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }
}
