import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Alert;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void testJavaAlert() {
        driver.get("https://webdriveruniversity.com/Popup-Alerts/index.html");
        WebElement button = driver.findElement(By.cssSelector("#button1"));
        actions.click(button).build().perform();
        Alert alert = driver.switchTo().alert();
        assertTrue(alert.getText().contains("I am an alert box!"));
        alert.accept();
    }

    @Test
    void testJavaConfirm() {
        driver.get("https://webdriveruniversity.com/Popup-Alerts/index.html");
        WebElement button = driver.findElement(By.cssSelector("#button4"));
        actions.click(button).build().perform();
        Alert alert = driver.switchTo().alert();
        assertTrue(alert.getText().contains("Press a button!"));
        alert.accept();
        assertTrue(driver.findElement(By.id("confirm-alert-text")).getText().contains("You pressed OK!"));
    }

    @Test
    void testModalPopup() {
        driver.get("https://webdriveruniversity.com/Popup-Alerts/index.html");
        WebElement button = driver.findElement(By.cssSelector("#button2"));
        actions.click(button).build().perform();

//        // Wait for the modal to be visible (increased timeout to 5 seconds)
//        WebElement modal = driver.findElement(By.id("myModal"));
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.visibilityOf(modal));

        // Assert specific elements or conditions in the modal
//        WebElement modalContent = driver.findElement(By.id("confirm-alert-text"));
//        assertTrue(modalContent.getText().contains("It's that Easy!! well i think it is....."));

        WebElement buttonModal = driver.findElement(By.cssSelector("#myModal > div > div > div.modal-footer > button"));
        actions.click(buttonModal).build().perform();

        // Optionally, you can assert that the modal is closed or handle any related actions
        // For example:
//        assertFalse(modal.isDisplayed());
    }

//    @AfterAll
//    static void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
    }
//}


neveikia
