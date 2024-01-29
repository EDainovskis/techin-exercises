import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ToDoListTest {

    private static WebDriver driver;
    private static Actions actions;
    private static ToDoListPage toDoListPage;

    @BeforeAll
    static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        actions = new Actions(driver);
        toDoListPage = new ToDoListPage(driver);
    }

    @Test
    void testWebElement() {
        driver.get("https://webdriveruniversity.com/To-Do-List/index.html");

        toDoListPage.getInputField().sendKeys("new list");
        toDoListPage.getInputField().sendKeys(Keys.ENTER);

        assertTrue(toDoListPage.getAddedItem().isDisplayed());
    }

    // Other test methods
}
