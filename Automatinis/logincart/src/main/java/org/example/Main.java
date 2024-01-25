import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Main { logincart

    private static WebDriver driver;

    @BeforeAll
    static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void testSearchBox() {
        driver.get("https://demo.opencart-extensions.co.uk/");

        WebElement cartButton = driver.findElement(By.cssSelector("#top-links > ul > li.dropdown > a > span.hidden-xs.hidden-sm.hidden-md"));
        cartButton.click();

        WebElement loginButton = driver.findElement(By.cssSelector("#top-links > ul > li.dropdown.open > ul > li:nth-child(2) > a"));
        loginButton.click();


        WebElement emailInput = driver.findElement(By.cssSelector("#input-email"));
        emailInput.sendKeys("tester@gmail.com");


        WebElement passwordInput = driver.findElement(By.cssSelector("#input-password"));
        passwordInput.sendKeys("tester");

        WebElement loginButton2 = driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
        loginButton2.click();


    }

    // Uncomment the @AfterAll method if you want to close the browser after the test
//    @AfterAll
//    static void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
