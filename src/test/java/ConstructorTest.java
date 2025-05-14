import PageObject.ConstructorPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BrowserTest{
    private WebDriver driver;

    ConstructorPage constructorPage;
    @Before
    public void setUp() {
        driver = getWebDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        constructorPage = new ConstructorPage(driver);

    }
    @Test
    public void testBunTab() {
        constructorPage.scrollMenuConstructor();
        constructorPage.clickBunTab();
        assertTrue("Секция найдена неправильно", constructorPage.checkBunsDisplayed());

    }
    @Test
    public void testSaucesTab() {
        constructorPage.scrollMenuConstructor();
        constructorPage.clickSaucesTab();
        assertTrue("Секция найдена неправильно", constructorPage.checkSauceDisplayed());

    }
    @Test
    public void testToppingsTab() {
        constructorPage.clickToppingsTab();
        assertTrue("Секция найдена неправильно", constructorPage.checkToppingDisplayed());
    }
    @After
    public void tearDown() {
        driver.quit();
    }



}

