import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    private static WebDriver driver;

    @BeforeAll
    static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void testLogin() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        LoginPage loginPage = new LoginPage(driver);

        String usernameText = loginPage.getUsernameText();
        String passwordText = loginPage.getPasswordText();

        System.out.println("Username: " + usernameText);
        System.out.println("Password: " + passwordText);

        loginPage.enterUsernameAndPassword(usernameText, passwordText);
        loginPage.clickLoginButton();


        String expectedDashboardUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedDashboardUrl, actualUrl, "Login failed: Dashboard page not reached");


    }
}
