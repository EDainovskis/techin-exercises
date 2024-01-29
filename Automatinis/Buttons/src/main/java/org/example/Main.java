import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Main {

    private static WebDriver driver;
    private static Actions actions;

    @BeforeAll
    static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        actions = new Actions(driver);
    }

    @Test
    void testWebElement() {
        driver.get("https://webdriveruniversity.com/Click-Buttons/index.html");

        WebElement button = driver.findElement(By.cssSelector("#button1"));
        actions.click(button).build().perform();

        WebDriverWait wait = new WebDriverWait(driver, (10));

        // Wait for the visibility of the second button
        WebElement button2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#myModalClick > div > div > div.modal-footer > button")));

        actions.click(button2).build().perform();
    }

    @Test
    void testJavaClick() {
        driver.get("https://webdriveruniversity.com/Click-Buttons/index.html");

        WebElement button = driver.findElement(By.cssSelector("#button2"));
        actions.click(button).build().perform();

        WebDriverWait wait = new WebDriverWait(driver, (10));

        // Wait for the visibility of the second button
        WebElement button3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(" #myModalJSClick > div > div > div.modal-footer > button")));

        actions.click(button3).build().perform();


//    @AfterAll
//    static void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
    }

    @Test
    void testAction() {
        driver.get("https://webdriveruniversity.com/Click-Buttons/index.html");

        WebElement button4 = driver.findElement(By.cssSelector("#button3"));
        actions.click(button4).build().perform();

        WebDriverWait wait = new WebDriverWait(driver, (10));

        // Wait for the visibility of the second button
        WebElement button8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(" #myModalMoveClick > div > div > div.modal-footer > button")));

        actions.click(button8).build().perform();
//
//}

}}