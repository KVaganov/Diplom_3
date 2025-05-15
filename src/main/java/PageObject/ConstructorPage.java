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
    private final By menuBlock = By.className("BurgerIngredients_ingredients__menuContainer__Xu3Mo");
    private final By currentTab = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span");



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

    public String getTextFromSelectedMenu() {
        return driver.findElement(currentTab).getText();
    }
}
