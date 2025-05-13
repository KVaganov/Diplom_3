package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ConstructorPage {
    private final WebDriver driver;
    //Локатор раздела Булки
    private final By bunTab = By.xpath(".//span[text() = 'Булки']");
    //Локатор раздела Соусы
    private final By saucesTab = By.xpath(".//span[text() = 'Соусы']");
    //Локатор раздела Начинки
    private final By toppingsTab = By.xpath(".//span[text() = 'Начинки']");
    //Локатор заголовка Булки
    private final By bunHeader = By.xpath(".//h2[text()= 'Булки']");
    //Локатор заголовка Соусы
    private final By saucesHeader = By.xpath(".//h2[text()= 'Соусы']");
    //Локатор заголовка Начинки
    private final By toppingsHeader = By.xpath(".//h2[text()= 'Начинки']");
    private final By menuBlock = By.className("BurgerIngredients_ingredients__menuContainer__Xu3Mo");

    private final By  checkBunsDisplayed = By.xpath(".//section[1]/div[2]/h2[1]");
    private final By checkSauceDisplayed = By.xpath(".//section[1]/div[2]/h2[2]");
    private final By checkToppingDisplayed = By.xpath(".//section[1]/div[2]/h2[3]");

    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
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

    public void visibilityMenuBlock(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(menuBlock));
        driver.findElement(menuBlock).isDisplayed();
    }
    public void scrollMenuConstructor(){
        WebElement element = driver.findElement(menuBlock);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", element);
    }
    // Метод получения текста кнопки "Посмотреть заказ"
    public String bunHeader() {
        return driver.findElement(bunHeader).getText();
    }

    public boolean checkBunsDisplayed() {
        driver.findElement(bunHeader).click();
        return driver.findElement(checkBunsDisplayed).isDisplayed();
    }
    public boolean checkSauceDisplayed() {
        driver.findElement(saucesHeader).click();
        return driver.findElement(checkSauceDisplayed).isDisplayed();
    }
    public boolean checkToppingDisplayed() {
        driver.findElement(toppingsHeader).click();
        return driver.findElement(checkToppingDisplayed).isDisplayed();
    }
}
