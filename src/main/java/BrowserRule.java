import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.rules.ExternalResource;

import java.util.concurrent.TimeUnit;

public class BrowserRule extends ExternalResource {

    private final static String URL= "https://stellarburgers.nomoreparties.site";

    private WebDriver driver;
    private String browserName;

    public BrowserRule() {
        this.browserName = System.getProperty("browser");
    }

    protected void before() {
        if (browserName == null) {
            browserName = "chrome";
        }
        switch (browserName) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                driver.get(URL);
                break;
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                driver.get(URL);
                break;
            default:
                throw new RuntimeException("Error while setting browser");
        }
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    protected void after() {
        driver.quit();
    }
}
