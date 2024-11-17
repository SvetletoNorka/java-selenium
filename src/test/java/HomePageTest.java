import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageTest {
    private WebDriver driver;
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;

    public void setUp() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        driver.navigate().to("https://mobile.bg");
        driver.manage().window().maximize();
        homePage.acceptCookies();
    }

    public void testSearchCar() {
        homePage.clickSearch();
        homePage.selectBrand("VW");
        homePage.selectModel("Golf");
        homePage.selectOtherOptions();
        homePage.clickSearchButton();
        searchResultsPage.openFirstCar();

        String phoneNumber = searchResultsPage.getPhoneNumber().split("\n")[0].trim();
        System.out.println("Phone number: " + phoneNumber);
        LogHelper.log("Phone number: " + phoneNumber);
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void main(String[] args) {
        HomePageTest test = new HomePageTest();
        test.setUp();
        test.testSearchCar();
        test.tearDown();
    }
}
