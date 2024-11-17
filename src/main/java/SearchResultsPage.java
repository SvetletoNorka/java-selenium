import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultsPage {
    private WebDriver driver;

    private By firstTopCar = By.xpath("(//div[@class='item TOP ']//a[@class='image saveSlink']//img[@class='pic'])[1]");
    private By phoneNumber = By.xpath("(//div[@class='phone'])[3]");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openFirstCar() {
        scrollToElement(firstTopCar);
        waitForElementToBeClickableAndClick(firstTopCar, 10);
    }

    public String getPhoneNumber() {
        //scrollToElement(phoneNumber);
        WebElement phoneNumberElement = driver.findElement(phoneNumber);
        return phoneNumberElement.getText();
    }

    public void waitForVisibilityOfElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement visibleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementToBeClickableAndClick(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        try {
            // Wait for the element to be clickable
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click(); // Click the element
        } catch (TimeoutException e) {
            // Log a meaningful message if the element is not clickable
            System.out.println("The element did not become clickable within " + timeoutInSeconds + " seconds.");
            e.printStackTrace();
        }
    }

    public void scrollToElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement visibleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", visibleElement);
    }


}