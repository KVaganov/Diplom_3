import PageObject.*;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static junit.framework.TestCase.assertTrue;

public class LoginTest extends BrowserTest{
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
        startPage.openMainPage();
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void loginTestPersonalAccount() {
        startPage.clickButtonPersonalAccount();
        registrationPage.loginUser(email, password);
        boolean actual = startPage.displayedButtonCreateUserOrder();
        assertTrue(actual);
        startPage.clickButtonPersonalAccount();
        startPage.clickButtonExit();
    }
    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void loginTestLogAccount() {
        startPage.clickButtonLogAccount();
        registrationPage.loginUser(email, password);
        boolean actual = startPage.displayedButtonCreateUserOrder();
        assertTrue(actual);
        startPage.clickButtonPersonalAccount();
        startPage.clickButtonExit();
    }
    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginTestOnRegistration() {
        startPage.clickButtonLogAccount();
        registrationPage.clickLinkRegistration();
        registrationPage.clickButtonLogin();
        registrationPage.loginUser(email, password);
        boolean actual = startPage.displayedButtonCreateUserOrder();
        assertTrue(actual);
        startPage.clickButtonPersonalAccount();
        startPage.clickButtonExit();
    }
    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginTestOnReconPassword() {
        startPage.clickButtonLogAccount();
        registrationPage.clickLinkRecoverPassword();
        registrationPage.clickButtonLogin();
        registrationPage.loginUser(email, password);
        boolean actual = startPage.displayedButtonCreateUserOrder();
        assertTrue(actual);
        startPage.clickButtonPersonalAccount();
        startPage.clickButtonExit();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
