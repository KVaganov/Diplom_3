package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class StartPage {
    private final WebDriver driver;
    //Локатор кнопки Войти в аккаунт
    private final By buttonLogAccount = By.xpath(".//button[contains(@class, 'button_button') and text()='Войти в аккаунт']");
    //Локатор кнопки Личный кабинет
    private final By buttonPersonalAccount = By.xpath(".//p[contains(@class, 'AppHeader_header') and text()='Личный Кабинет']");
    //Локатор заголовка Вход
    private final By headInput = By.xpath(".//div[contains(@class, 'Auth_login')]/h2[text() = 'Вход']");
    //Локатор заголовка Вход
    private final By headRegistration = By.xpath(".//div[contains(@class, 'Auth_login')]/h2[text() = 'Регистрация']");
    //Локатор ссылки Зарегистрироваться
    private final By linkRegistration = By.xpath(".//a[contains(@class, 'Auth_link') and text() = 'Зарегистрироваться']");
    //Локатор ссылки Восстановить пароль
    private final By linkRecoverPassword = By.xpath(".//a[contains(@class, 'Auth_link') and text() = 'Восстановить пароль']");
    //Локатор поля Имя
    private final By nameField = By.xpath(".//label[contains(@class, 'input') and text() = 'Имя']");
    //Локатор поля Email
    private final By emailField = By.xpath(".//label[contains(@class, 'input') and text() = 'Email']");
    //Локатор поля Пароль
    private final By passwordField = By.xpath(".//label[contains(@class, 'input') and text() = 'Пароль']");
    //Локатор кнопки Войти
    private final By buttonLog = By.xpath(".//button[contains(@class, 'button_button') and text()='Войти']");
    //Локатор кнопки Зарегистрироваться
    private final By buttonRegistration = By.xpath(".//button[contains(@class, 'button_button') and text()='Зарегистрироваться']");
    //Локатор кнопки Конструктор
    private final By buttonСonstructor = By.xpath(".//p[text() = 'Конструктор']");
    //Локатор кнопки StellarBurgers
    private final By buttonHeaderStellarBurgers = By.className("AppHeader_header__logo__2D0X2");
    //Локатор раздела Булки
    private final By bunTab = By.xpath(".//span[text() = 'Булки']");
    //Локатор раздела Соусы
    private final By saucesTab = By.xpath(".//span[text() = 'Соусы']");
    //Локатор раздела Начинки
    private final By toppingsTab = By.xpath(".//span[text() = 'Начинки']");
    private final By lastImg = By.xpath(".//img[contains(@alt, 'Сыр с астероидной плесенью')]");
    //Локатор заголовка Булки
    private final By bunHeader = By.xpath(".//h2[text()= 'Булки']");
    //Локатор заголовка Соусы
    private final By saucesHeader = By.xpath(".//h2[text()= 'Соусы']");
    //Локатор заголовка Начинки
    private final By toppingsHeader = By.xpath(".//h2[text()= 'Начинки']");
    private final By menuBlock = By.className("BurgerIngredients_ingredients__menuContainer__Xu3Mo");

    public StartPage(WebDriver driver) {
        this.driver = driver;
    }
    //Метод нажатия на кнопку Войти в аккаунт
    public void clickButtonLogAccount() {
        driver.findElement(buttonLogAccount).click();
    }
    //Метод нажатия на кнопку Войти в аккаунт
    public void clickButtonPersonalAccount() {
        driver.findElement(buttonPersonalAccount).click();
    }
    // Метод получения текста "Вход"
    public String checkHeadInput() {
        return driver.findElement(headInput).getText();
    }
    // Метод получения текста "Регистрация"
    public String checkHeadRegistration() {
        return driver.findElement(headRegistration).getText();
    }
    //Метод нажатия на ссылку Зарегистрироваться
    public void clickLinkRegistration() {
        driver.findElement(linkRegistration).click();
    }
    //Метод нажатия на ссылку Восстановить пароль
    public void clickLinkRecoverPassword() {
        driver.findElement(linkRecoverPassword).click();
    }
    public void clickButtonLog() {
        driver.findElement(buttonLog).click();
    }
    // Метод заполнения поля Имя
    public void setNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }
    // Метод заполнения поля Email
    public void setEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    // Метод заполнения поля Пароль
    public void setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    //Метод нажатия на кнопку Зарегистрироваться
    public void clickButtonRegistration() {
        driver.findElement(buttonRegistration).click();
    }
    //Метод нажатия на кнопку Конструктор
    public void clickButtonСonstructor() {
        driver.findElement(buttonСonstructor).click();
    }
    //Метод нажатия на кнопку StellarBurgers
    public void clickButtonHeaderStellarBurgers() {
        driver.findElement(buttonHeaderStellarBurgers).click();
    }
    //Метод нажатия на раздел Булки
    public void clickBunTab() {
        driver.findElement(bunTab).click();
    }
    //Метод нажатия на раздел Соусы
    public void clickSaucesTab() {
        driver.findElement(saucesTab).click();
    }
    //Метод нажатия на раздел Начинки
    public void clickToppingsTab() {
        driver.findElement(toppingsTab).click();
    }

    public boolean visibilityMenuBlock(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(menuBlock));
        return driver.findElement(menuBlock).isDisplayed();
    }
    public void scrollMenuConstructor(){
        WebElement element = driver.findElement(menuBlock);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", element);
    }
    // Метод получения текста кнопки "Посмотреть заказ"
    public String bunHeader() {
        return driver.findElement(bunHeader).getText();
    }


}
