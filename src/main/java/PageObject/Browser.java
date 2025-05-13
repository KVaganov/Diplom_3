package PageObject;

import org.openqa.selenium.WebDriver;

public class Browser {
    protected WebDriver driver;

    public Browser(WebDriver driver) {
        this.driver = driver;
    }
}
