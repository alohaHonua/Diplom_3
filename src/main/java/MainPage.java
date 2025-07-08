import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private WebDriver driver;

    public MainPage (WebDriver driver) {
        this.driver = driver;
    }

    private By loginButton = By.xpath(".//button[text() = 'Войти в аккаунт']");

    private By personalAccountButton = By.xpath(".//p[text() = 'Личный Кабинет']");

    private By constructorButton = By.xpath(".//p[text() = 'Конструктор']");

    private By logo = By.xpath(".//div[contains(@class, 'logo')]");

    private By activeTab = (By.xpath(".//div[contains(@class, 'tab_type_current')]"));

    private By bunsButton = By.xpath(".//span[text()='Булки']/..");

    private By sauceButton = By.xpath(".//span[text()='Соусы']/..");

    private By fillingButton = By.xpath(".//span[text()='Начинки']/..");

    @Step ("Click on login button on Main page")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step ("Click on constructor button on Main page")
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    @Step ("Click on Personal Account button on Main page")
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    @Step ("Click on logo button on Main page")
    public void clickLogoButton() {
        driver.findElement(logo).click();
    }

    @Step ("Click on buns button on Main page")
    public void clickBunsButton() {
        driver.findElement(bunsButton).click();
    }

    @Step ("Click on sauce button on Main page")
    public void clickSauceButton() {
        driver.findElement(sauceButton).click();
    }

    @Step ("Click on filling button on Main page")
    public void clickFillingButton() {
        driver.findElement(fillingButton).click();
    }

    @Step("Active tab name check")
    public String getActiveTabName() {
        return driver.findElement(activeTab).getText();
    }

    @Step("Waits until elements are loaded")
    public void waitForElementsToLoad() {
        new WebDriverWait(driver, 5);
    }

}
