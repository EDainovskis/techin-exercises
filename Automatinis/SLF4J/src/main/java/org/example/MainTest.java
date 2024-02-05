import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainTest {

    private static WebDriver driver;

    @BeforeAll
    static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void testWebElement() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateTo();
        homePage.clickCreateAccountButton();
    }

    @Test
    void testRegistration() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.navigateTo();
        registrationPage.enterRegistrationDetails("eee@test.com", "test123", "test123", "tester");
        registrationPage.clickRegistrationButton();
    }

    @Test
    void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateTo();
        loginPage.enterLoginDetails("eee@test.com", "test123");
        loginPage.clickLoginButton();
    }
}
