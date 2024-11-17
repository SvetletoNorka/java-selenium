import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultsPage {
    private WebDriver driver;

    private By firstTopCar = By.xpath("(//div[@class='item TOP ']//a[@class='image saveSlink']//img[@class='pic'])[1]");
    private By phoneNumber = By.xpath("(//div[@class='phone']/text()[normalize-space()])[2]");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

  //  public void openFirstCar() {
//        WebElement firstCar = driver.findElement(firstTopCar);
//        firstCar.click();
//    }

    public void openFirstCar() {
        // Изчакване за елемента да бъде видим и кликаем
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstCar = wait.until(ExpectedConditions.visibilityOfElementLocated(firstTopCar)); // чака, докато елементът стане видим

        // Скролиране до елемента
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", firstCar);

        // Изчакване за кликаемост
        try {
            wait.until(ExpectedConditions.elementToBeClickable(firstCar)); // чака, докато елементът стане кликаем
            firstCar.click();
        } catch (TimeoutException e) {
            System.out.println("Елементът не стана кликаем в рамките на зададеното време.");
            e.printStackTrace();
        }
    }

    public String getPhoneNumber() {
        WebElement phoneNumberElement = driver.findElement(phoneNumber);
        return phoneNumberElement.getText();
    }
}