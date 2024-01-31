import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IncorrectLoginTest {

    private static WebDriver driver;

    @BeforeAll
    static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void testIncorrectLogin() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        LoginPage loginPage = new LoginPage(driver);


        String incorrectUsername = "incorrectUsername";
        String incorrectPassword = "incorrectPassword";

        loginPage.enterUsernameAndPassword(incorrectUsername, incorrectPassword);
        loginPage.clickLoginButton();


    }
}
