//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class Main {
//
//    private static WebDriver driver;
//    private static ToDoListPage toDoListPage;
//
//    @BeforeAll
//    static void setUp() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        toDoListPage = new ToDoListPage(driver);
//    }
//
//    @Test
//    void testWebElement() {
//        driver.get("https://webdriveruniversity.com/To-Do-List/index.html");
//
//        toDoListPage.getInputField().sendKeys("new list");
//        toDoListPage.getInputField().sendKeys(Keys.ENTER);
//
//        assertTrue(toDoListPage.isElementPresent(toDoListPage.getAddedItem()));
//    }
//
//    @Test
//    void checked() {
//        driver.get("https://webdriveruniversity.com/To-Do-List/index.html");
//
//        toDoListPage.markItemAsCompleted();
//        assertTrue(toDoListPage.isElementPresent(toDoListPage.getCompletedItem()));
//
//        // Rest of your test logic
//    }
//
//    @Test
//    void delete() {
//        driver.get("https://webdriveruniversity.com/To-Do-List/index.html");
//
//        // Assuming you have an item to delete
//        toDoListPage.deleteItem();
//        assertFalse(toDoListPage.isElementPresent(toDoListPage.getAddedItem()));
//
//        // Rest of your test logic
//    }
//
//    @AfterAll
//    static void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}
