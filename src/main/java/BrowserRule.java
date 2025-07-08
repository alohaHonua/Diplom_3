import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.rules.ExternalResource;

public class BrowserRule extends ExternalResource {

    private final static String URL= "https://stellarburgers.nomoreparties.site";
    private WebDriver driver;

    protected void before() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get(URL);
    }

    protected void after() {
        driver.quit();
    }

    public WebDriver getWebDriver() {
        return driver;
    }
}
