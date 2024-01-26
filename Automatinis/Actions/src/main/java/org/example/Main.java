import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Main {

    private static WebDriver driver;

    @BeforeAll
    static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void testDnD() {
        driver.get("http://webdriveruniversity.com/Actions/index.html");
        WebElement From = driver.findElement(By.cssSelector("#draggable > p > b"));
        WebElement To = driver.findElement(By.cssSelector("#droppable > p"));
        Actions act = new Actions(driver);
        act.dragAndDrop(From, To).build().perform();
    }

    @Test
    void testDoubleClick() {
        Actions actions = new Actions(driver);
        driver.get("http://webdriveruniversity.com/Actions/index.html");
        WebElement doubleClickB = driver.findElement(By.cssSelector("#double-click"));
        String colorBeforeDoubleClick = doubleClickB.getCssValue("background-color");
        actions.doubleClick(doubleClickB).build().perform();
        String colorAfterDoubleClick = doubleClickB.getCssValue("background-color");

        assertNotEquals(colorBeforeDoubleClick, colorAfterDoubleClick, "Color should change after double-click");
    }


    @Test
    void testHover() {
        Actions actions = new Actions(driver);
        driver.get("http://webdriveruniversity.com/Actions/index.html");

        WebElement hoverButton = driver.findElement(By.cssSelector("#div-hover > div.dropdown.hover > button"));
        actions.moveToElement(hoverButton).perform();
        WebElement subElement = driver.findElement(By.cssSelector("#div-hover > div.dropdown.hover > div > a"));
        assertTrue(subElement.isDisplayed(), "Sub-element should be displayed after hover");

    }

    @Test
    void testClickHold() {
        Actions actions = new Actions(driver);
        driver.get("http://webdriveruniversity.com/Actions/index.html");

        WebElement clickHold = driver.findElement(By.cssSelector("#click-box"));
        String colorBeforeClick = clickHold.getCssValue("background-color");
        actions.clickAndHold(clickHold).perform();
        String colorAfterClick = clickHold.getCssValue("background-color");
        assertNotEquals(colorBeforeClick, colorAfterClick, "Color should change after double-click");

//    @AfterAll
//    static void tearDown() {
//        if (driver != null) {
//            driver.quit();
    }
//    }
//}
}