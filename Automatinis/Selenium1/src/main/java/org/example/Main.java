import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Main {

    private static WebDriver driver;

    @BeforeAll
    static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void testCart() {
        driver.get("https://demo.opencart.com/");

        WebElement cartButton = driver.findElement(By.cssSelector("#wishlist-total > span"));
        cartButton.click();

        List<WebElement> searchBoxes = driver.findElements(By.tagName("input"));
        int numberOfSearchBoxes = searchBoxes.size();
        System.out.println("Number of search boxes: " + numberOfSearchBoxes);
    }

    @Test
    void testSearchBox() {
        driver.get("https://demo.opencart.com/");

        WebElement cartButton = driver.findElement(By.cssSelector("#wishlist-total > span"));
        cartButton.click();

        List<WebElement> searchBoxes = driver.findElements(By.tagName("input"));
        int numberOfSearchBoxes = searchBoxes.size();
        System.out.println("Number of search boxes: " + numberOfSearchBoxes);
    }

    @Test
    void testInput() {
        driver.get("https://demo.opencart.com/index.php?route=account/register&language=en-gb");


        WebElement passwordInput = driver.findElement(By.cssSelector("#input-password"));
        boolean isPasswordEnabled = passwordInput.isEnabled();
        System.out.println("Is the password input field enabled? " + isPasswordEnabled);
        assertTrue(isPasswordEnabled, "Password input field should be enabled");


        WebElement cartElement = driver.findElement(By.cssSelector("#header-cart > div > button"));
        boolean isCartDisplayed = cartElement.isDisplayed();
        System.out.println("Is the cart element displayed? " + isCartDisplayed);
        assertTrue(isCartDisplayed, "Cart element should be displayed");

        WebElement agreeCheckbox = driver.findElement(By.cssSelector("#form-register > div > div > div > input"));
        boolean isAgreeSelected = agreeCheckbox.isSelected();
        System.out.println("Is the 'Agree' checkbox selected? " + isAgreeSelected);
        assertTrue(isAgreeSelected, "'Agree' checkbox should be selected");
    }
//    @AfterAll
//    static void tearDown() {
//        if (driver != null) {
//            driver.quit();
        }
//    }
//}
