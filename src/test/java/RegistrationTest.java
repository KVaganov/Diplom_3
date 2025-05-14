import PageObject.*;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;


public class RegistrationTest extends BrowserTest{
    private WebDriver driver;
    private StartPage startPage;
    private RegistrationPage registrationPage;
    private String email;
    private String name;
    private String password;
    private ConstructorPage constructorPage;
    User user;
    
    @Before
    public void setUp() {
        driver = getWebDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        email = RandomStringUtils.randomAlphabetic(15) + "@yandex.ru";
        password = RandomStringUtils.randomAlphabetic(15);
        name = RandomStringUtils.randomAlphabetic(15);
        user = new User(name, email, password);
        startPage = new StartPage(driver);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        constructorPage = new ConstructorPage(driver);
        registrationPage = new RegistrationPage(driver);
    }


    @Test
    public void registrationPositiveTest() {
        constructorPage.visibilityMenuBlock();
        startPage.clickButtonPersonalAccount();
        registrationPage.clickLinkRegistration();
        registrationPage.createUser(name,email,password);
        boolean actual = registrationPage.displayedButtonLog();
        assertTrue(actual);
    }
    @Test
    public void registrationNegativeTest() {
        constructorPage.visibilityMenuBlock();
        startPage.clickButtonPersonalAccount();
        registrationPage.clickLinkRegistration();
        registrationPage.createUser(name,email,"12345");
        assertEquals("Регистрация невозможна", "Некорректный пароль", registrationPage.errorMessageText());
    }
    @After
    @DisplayName("Закрытие браузера и удаление юзера")
    public void deleteUserAndCloseBrowser() {

        String response = new UserDelete()
                .loginUser(user)
                .extract().body()
                .path("accessToken");
        if (response != null){
            new UserDelete().deleteUser(response);
        }
        driver.quit();
    }
}
