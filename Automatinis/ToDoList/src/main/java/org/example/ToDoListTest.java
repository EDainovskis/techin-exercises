import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ToDoListTest {
    private static WebDriver driver;
    private static ToDoListPage toDoListPage;

    @BeforeAll
    static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        toDoListPage = new ToDoListPage(driver);
    }

    @Test
    void testAddTask() {
        driver.get("https://webdriveruniversity.com/To-Do-List/index.html");


        toDoListPage.addTask("new list");


        assertTrue(toDoListPage.isTaskPresent("new list"));
    }

    @Test
    void testMarkTaskAsCompleted() {
        driver.get("https://webdriveruniversity.com/To-Do-List/index.html");


        toDoListPage.addTask("new list");


        toDoListPage.markTaskAsCompleted(1);


        assertTrue(toDoListPage.isTaskCompleted(1));
    }

    @Test
    void testDeleteTask() {
        driver.get("https://webdriveruniversity.com/To-Do-List/index.html");


        toDoListPage.addTask("new list");


        toDoListPage.deleteTask(1);


        assertTrue(toDoListPage.isTaskPresent("new list"));
    }

    @AfterAll
    static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
