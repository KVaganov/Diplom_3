import PageObject.ConstructorPage;
import PageObject.RegistrationPage;
import PageObject.StartPage;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

public class TransitionLogoAndConstructorTest extends BrowserTest{
    private WebDriver driver;
    StartPage startPage;
    private RegistrationPage registrationPage;
    private String email;
    private String name;
    private String password;

    @Before
    public void setUp() {
        getWebDriver();
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        email = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
        password = RandomStringUtils.randomAlphabetic(10);
        name = RandomStringUtils.randomAlphabetic(10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        startPage = new StartPage(driver);
        startPage.clickButtonPersonalAccount();
        registrationPage = new RegistrationPage(driver);
        registrationPage.clickLinkRegistration();
        registrationPage.createUser(name,email,password);
        registrationPage.loginUser(email, password);

    }
    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на «Конструктор»»")
    public void transitionConstructorTest() {
        startPage.clickButtonPersonalAccount();
        startPage.clickButtonСonstructor();
        boolean actual = startPage.displayedButtonCreateUserOrder();
        assertTrue(actual);
    }
    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип Stellar Burgers»")
    public void transitionLogoTest() {
        startPage.clickButtonPersonalAccount();
        startPage.clickLogoButton();
        boolean actual = startPage.displayedButtonCreateUserOrder();
        assertTrue(actual);
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
