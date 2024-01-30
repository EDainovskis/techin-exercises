//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//
//public class Main {
//
//    private static WebDriver driver;
//    private static Actions actions;
//
//    @BeforeAll
//    static void setUp() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        actions = new Actions(driver);
//    }
//
//    @Test
//    void testWebElement() {
//        driver.get("https://webdriveruniversity.com/To-Do-List/index.html");
//
//        WebElement inputField = driver.findElement(By.cssSelector("#container > input[type=text]"));
//
//        inputField.sendKeys("new list");
//
//        inputField.sendKeys(Keys.ENTER);
//
//        WebElement addedItem = driver.findElement(By.cssSelector("#container > ul > li"));
//    }
//
//    @Test
//    void checked() {
//        driver.get("https://webdriveruniversity.com/To-Do-List/index.html");
//
//
//        WebElement firstContainer = driver.findElement(By.cssSelector("#container > ul > li:nth-child(1)"));
//
//        actions.click(firstContainer).build().perform();
//        assertTrue(firstContainer.getAttribute("class").contains("completed"));
//
//
//        WebElement secondContainer = driver.findElement(By.cssSelector("#container > ul > li:nth-child(2)"));
//
//        assertFalse(secondContainer.getAttribute("class").contains("completed"));
//
//        WebElement thirdContainer = driver.findElement(By.cssSelector("#container > ul > li:nth-child(3)"));
//        assertFalse(thirdContainer.getAttribute("class").contains("completed"));
//
//
////        WebElement fourthContainer = driver.findElement(By.cssSelector("#container > ul > li:nth-child(4)"));
////        assertFalse(fourthContainer.getAttribute("class").contains("completed"));
////
////
////        WebElement fifthContainer = driver.findElement(By.cssSelector("#container > ul > li:nth-child(5)"));
////        assertFalse(fifthContainer.getAttribute("class").contains("completed"));
//    }
//
//    @Test
//    void delete() {
//        driver.get("https://webdriveruniversity.com/To-Do-List/index.html");
//
//        WebElement secondContainer = driver.findElement(By.cssSelector("#container > ul > li:nth-child(2)"));
//
//        actions.moveToElement(secondContainer).perform();
//
//        WebElement deleteContainer = driver.findElement(By.cssSelector("#container > ul > li:nth-child(2) > span"));
//
//
//        actions.click(deleteContainer).build().perform();
//    }
//        private boolean isElementPresent (WebElement element){
//            try {
//                return element.isDisplayed();
//            } catch (org.openqa.selenium.NoSuchElementException e) {
//                return false;
//            }
//        }
//    }