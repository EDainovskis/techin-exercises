import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

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
    void testWebElement() {

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");


        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("page-menu")));


        Select dropdownSelect = new Select(dropdown);


        dropdownSelect.selectByVisibleText("20");


        WebElement button = driver.findElement(By.cssSelector("tr > th:nth-of-type(1)"));
        Actions actions = new Actions(driver);
        actions.click(button).build().perform();


        verifyTableSorting("table.table-bordered > tbody", 0);
    }

    private void verifyTableSorting(String tableSelector, int columnIndex) {

        WebElement table = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(tableSelector)));


        List<WebElement> rows = table.findElements(By.tagName("tr"));


        boolean sorted = true;


        for (int i = 1; i < rows.size() - 1; i++) {
            WebElement currentRow = rows.get(i);
            WebElement nextRow = rows.get(i + 1);


            String currentCellText = currentRow.findElements(By.tagName("td")).get(columnIndex).getText();
            String nextCellText = nextRow.findElements(By.tagName("td")).get(columnIndex).getText();


            if (currentCellText.compareTo(nextCellText) > 0) {
                sorted = false;
                break;
            }
        }


        assertTrue(sorted, "Table is not sorted by the specified column");
    }

    @Test
    void testFilter() {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("page-menu")));
        Select dropdownSelect = new Select(dropdown);
        dropdownSelect.selectByVisibleText("20");


        WebElement inputField = driver.findElement(By.cssSelector("input#search-field"));
        inputField.sendKeys("a");


        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loading-spinner")));


        List<WebElement> rows = driver.findElements(By.cssSelector("table.table-bordered > tbody > tr"));
        for (WebElement row : rows) {
            String itemName = row.findElement(By.cssSelector("td:nth-of-type(1)")).getText().toLowerCase();
            assertTrue(itemName.contains("a"), "Item name does not contain 'a' after filtering");
        }
    }
}