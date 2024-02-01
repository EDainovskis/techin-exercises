import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class Main {

    private static WebDriver driver;

    @BeforeAll
    static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void testWebElement() {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        OfferPage offerPage = PageFactory.initElements(driver, OfferPage.class);


        offerPage.filterResults("20");
        offerPage.sortTableByColumn(0);
        offerPage.verifyTableSorting(0);
    }

    @Test
    void testFilter() {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        OfferPage offerPage = PageFactory.initElements(driver, OfferPage.class);

        offerPage.filterResults("20");
        offerPage.filterResultsByName("a");

        offerPage.verifyFilterResultsContain("a");
    }
}
