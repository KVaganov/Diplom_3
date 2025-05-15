package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private final WebDriver driver;


    private final By buttonLogin = By.xpath(".//a[text() = 'Войти']");
    //Локатор поля Email
    private final By nameField = By.xpath(".//label[text()='Имя']/../input[@class='text input__textfield text_type_main-default']");
    private final By passwordField = By.xpath(".//label[text()='Пароль']/../input[@class='text input__textfield text_type_main-default']");
    private final By emailField = By.xpath(".//label[text()='Email']/../input[@class='text input__textfield text_type_main-default']");
    private final By errorMessageText = By.xpath(".//fieldset[3]/div/p[contains(text(), 'Некорректный пароль')]");
    //Локатор кнопки Зарегистрироваться
    private final By buttonRegistration = By.xpath(".//button[contains(@class, 'button_button') and text()='Зарегистрироваться']");
    //Локатор кнопки Войти
    private final By buttonLog = By.xpath(".//button[contains(@class, 'button_button') and text()='Войти']");
    //Локатор ссылки Зарегистрироваться
    private final By linkRegistration = By.xpath(".//a[contains(@class, 'Auth_link') and text() = 'Зарегистрироваться']");
    //Локатор ссылки Восстановить пароль
    private final By linkRecoverPassword = By.xpath(".//a[contains(@class, 'Auth_link') and text() = 'Восстановить пароль']");


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public String errorMessageText() {
        return driver.findElement(errorMessageText).getText();
    }
    public void createUser(String name, String email, String password) {
        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(buttonRegistration).click();
    }
    public void loginUser(String email, String password){
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ignored){
        }
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(buttonLog).click();
    }
    public boolean displayedButtonLog() {
        return driver.findElement(buttonLog).isDisplayed();
    }
    //Метод нажатия на кнопку Войти
    public void clickButtonLogin() {
        driver.findElement(buttonLogin).click();
    }
    //Метод нажатия на ссылку Зарегистрироваться
    public void clickLinkRegistration() {
        driver.findElement(linkRegistration).click();
    }
    //Метод нажатия на ссылку Восстановить пароль
    public void clickLinkRecoverPassword() {
        driver.findElement(linkRecoverPassword).click();
    }

}
