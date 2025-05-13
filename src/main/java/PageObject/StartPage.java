package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartPage {
    private final WebDriver driver;
    //Локатор кнопки Войти в аккаунт
    private final By buttonLogAccount = By.xpath(".//button[contains(@class, 'button_button') and text()='Войти в аккаунт']");
    //Локатор кнопки Личный кабинет
    private final By buttonPersonalAccount = By.xpath(".//p[contains(@class, 'AppHeader_header') and text()='Личный Кабинет']");
    //Локатор кнопки Конструктор
    private final By buttonСonstructor = By.xpath(".//p[text() = 'Конструктор']");
    //Локатор кнопки StellarBurgers
    private final By logoButton = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']/a[@href='/' ]");
    //Локатор кнопки Оформить заказ
    private final By buttonCreateOrder = By.xpath(".//button[text() = 'Оформить заказ']");
    //Локатор кнопки Выход
    private final By buttonExit = By.xpath(".//button[text() = 'Выход']");
    private final static String mainPage = "https://stellarburgers.nomoreparties.site/";
    public void openMainPage(){
        driver.get(mainPage);
    }
    //Метод нажатия на кнопку Выход
    public void clickButtonExit() {
        driver.findElement(buttonExit).click();
    }
    public StartPage(WebDriver driver) {
        this.driver = driver;
    }
    //Метод нажатия на кнопку Войти в аккаунт
    public void clickButtonLogAccount() {
        driver.findElement(buttonLogAccount).click();
    }
    //Метод нажатия на кнопку Личный кабинет
    public void clickButtonPersonalAccount() {
        driver.findElement(buttonPersonalAccount).click();
    }

    //Метод проверка отображения кнопки Оформить заказ
    public boolean displayedButtonCreateUserOrder() {
        return driver.findElement(buttonCreateOrder).isDisplayed();
    }

    //Метод нажатия на кнопку Конструктор
    public void clickButtonСonstructor() {
        driver.findElement(buttonСonstructor).click();
    }
    //Метод нажатия на кнопку StellarBurgers
    public void clickLogoButton() {
        driver.findElement(logoButton).click();
    }




}
