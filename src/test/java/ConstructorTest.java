import PageObject.ConstructorPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

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
        Assert.assertEquals("Булки", constructorPage.getTextFromSelectedMenu());

    }
    @Test
    public void testSaucesTab() {
        constructorPage.scrollMenuConstructor();
        constructorPage.clickSaucesTab();
        Assert.assertEquals("Соусы", constructorPage.getTextFromSelectedMenu());

    }
    @Test
    public void testToppingsTab() {
        constructorPage.clickToppingsTab();
        Assert.assertEquals("Начинки", constructorPage.getTextFromSelectedMenu());
    }
    @After
    public void tearDown() {
        driver.quit();
    }



}

