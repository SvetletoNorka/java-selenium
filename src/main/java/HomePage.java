import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
    private WebDriver driver;

    private By acceptCookiesButton = By.id("cookiescript_accept");
    private By searchButton = By.xpath("//a[@href='//www.mobile.bg/search/avtomobili-dzhipove' and text()='Търсене']");
    private By brandDropdown = By.name("f5");
    private By modelDropdown = By.name("f6");
    private By otherOptionsDropdown = By.id("eimg88");
    private By searchFormButton = By.xpath("//input[@type='button' and @value='Т Ъ Р С И']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptCookies() {
        WebElement acceptButton = driver.findElement(acceptCookiesButton);
        acceptButton.click();
    }

    public void clickSearch() {
        WebElement searchBtn = driver.findElement(searchButton);
        searchBtn.click();
    }

    public void selectBrand(String brand) {
        WebElement brandDropdownElement = driver.findElement(brandDropdown);
        Select brandSelect = new Select(brandDropdownElement);
        brandSelect.selectByVisibleText(brand);
    }

    public void selectModel(String model) {
        WebElement modelDropdownElement = driver.findElement(modelDropdown);
        Select modelSelect = new Select(modelDropdownElement);
        modelSelect.selectByVisibleText(model);
    }

    public void selectOtherOptions() {
        WebElement otherOptionsDropdownElement = driver.findElement(otherOptionsDropdown);
        otherOptionsDropdownElement.click();
    }

    public void clickSearchButton() {
        WebElement searchButtonElement = driver.findElement(searchFormButton);
        searchButtonElement.click();
    }
}