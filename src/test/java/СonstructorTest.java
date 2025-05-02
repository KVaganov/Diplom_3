import PageObject.StartPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class СonstructorTest {
    private WebDriver driver;
    private StartPage startPage;
    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/");
        startPage = new StartPage(driver);

    }
    @Test
    public void testBunTab() {
        startPage.visibilityMenuBlock();
        startPage.clickButtonСonstructor();
        startPage.scrollMenuConstructor();
        startPage.clickBunTab();
        startPage.bunHeader();

    }
    @Test
    public void testSaucesTab() {
        startPage.visibilityMenuBlock();
        startPage.clickButtonСonstructor();
        startPage.clickSaucesTab();

    }
    @Test
    public void testToppingsTab() {
        startPage.visibilityMenuBlock();
        startPage.clickButtonСonstructor();
        startPage.clickToppingsTab();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

