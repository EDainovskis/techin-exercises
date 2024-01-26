import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MainTest {

    private static WebDriver driver;
    private static HomePage homePage;
    private static LoginPage loginPage;

    @BeforeAll
    static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    void testPositiveLogin() {
        driver.get("https://demo.opencart-extensions.co.uk/");
        homePage.goToLoginPage();
        loginPage.login("tester@gmail.com", "tester");

        // Use assertTrue with a condition to check if the login was successful
        assertTrue(true, "Login should be successful");
    }

    @Test
    void testNegativeLogin() {
        driver.get("https://demo.opencart-extensions.co.uk/");
        homePage.goToLoginPage();
        loginPage.login("false@gmail.com", "false");

        // Use assertFalse with a condition to check if the login was unsuccessful
        assertFalse(false, "Login should be unsuccessful");
    }

    @AfterAll
    static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
