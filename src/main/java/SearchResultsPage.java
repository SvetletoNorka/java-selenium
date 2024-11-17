import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage {
    private WebDriver driver;

    private By firstTopCar = By.xpath("(//div[@class='item TOP ']//a[@class='image saveSlink']//img[@class='pic'])[1]");
    private By phoneNumber = By.xpath("(//div[@class='phone']/text()[normalize-space()])[2]");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openFirstCar() {
        WebElement firstCar = driver.findElement(firstTopCar);
        firstCar.click();
    }

    public String getPhoneNumber() {
        WebElement phoneNumberElement = driver.findElement(phoneNumber);
        return phoneNumberElement.getText();
    }
}