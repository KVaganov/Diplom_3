import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserTest {
    protected WebDriver driver;
    private String browserItem;

    public BrowserTest() {
        this.browserItem = System.getProperty("browser");
    }

    public WebDriver getWebDriver() {
        if (browserItem == null) {
            browserItem = "chrome";
        }
        WebDriver driver;
        switch (browserItem) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "/Путь до драйвера chrome");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "/Путь до драйвера yandex");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            default:
                throw new RuntimeException("Некорректный браузер");
        }
        return driver;
    }
}
