import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import static org.junit.jupiter.api.Assertions.*;

public class Main {

    private static WebDriver driver;
    private TracaloriePage tracaloriePage;

    @BeforeAll
    static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeEach
    void openTracaloriePage() {
        tracaloriePage = new TracaloriePage(driver);
        tracaloriePage.openPage();
    }

    @Test
    void testCalorieTracking() {
        tracaloriePage.addFoodItem("name2", "30");
        tracaloriePage.addFoodItem("name", "35");

        int totalCalories = tracaloriePage.getTotalCalories();
        System.out.println("Total Calories: " + totalCalories);

        tracaloriePage.clearAllItems();

        int updatedTotalCalories = tracaloriePage.getTotalCalories();
        assertEquals(0, updatedTotalCalories, "Total Calories is not 0 after clearing");
    }

//    @AfterAll
//    static void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }


    static class TracaloriePage {

        private final WebDriver driver;
        private final WebDriverWait wait;

        public TracaloriePage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, 10);
        }

        public void openPage() {
            driver.get("https://practice.expandtesting.com/tracalorie/");
        }

        public void addFoodItem(String itemName, String calories) {
            WebElement inputName = driver.findElement(By.cssSelector("input#item-name"));
            inputName.sendKeys(itemName);
            inputName.sendKeys(Keys.ENTER);

            WebElement inputCalories = driver.findElement(By.cssSelector("input#item-calories"));
            inputCalories.sendKeys(calories);
            inputCalories.sendKeys(Keys.ENTER);

            WebElement addButton = driver.findElement(By.cssSelector(".add-btn.blue.btn.darken-3"));
            addButton.click();
        }

        public int getTotalCalories() {
            WebElement totalCaloriesElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='total-calories']")));
            String totalCaloriesText = totalCaloriesElement.getText();
            try {
                return Integer.parseInt(totalCaloriesText);
            } catch (NumberFormatException e) {
                System.out.println("Unable to parse total calories");
                e.printStackTrace();
                return -1;
            }
        }

        public void clearAllItems() {
            WebElement clearButton = driver.findElement(By.cssSelector(".blue.btn.clear-btn.lighten-3"));
            clearButton.click();

            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[@class='total-calories']"), "0"));
        }
    }
}
