import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OfferPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "page-menu")
    private WebElement dropdown;

    @FindBy(css = "tr > th:nth-of-type(1)")
    private WebElement columnHeader;

    @FindBy(css = "table.table-bordered > tbody")
    private WebElement table;

    @FindBy(css = "input#search-field")
    private WebElement inputField;

    @FindBy(css = "div.loading-spinner")
    private WebElement loadingSpinner;

    public OfferPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void filterResults(String visibleText) {
        Select dropdownSelect = new Select(dropdown);
        dropdownSelect.selectByVisibleText(visibleText);
    }

    public void sortTableByColumn(int columnIndex) {
        columnHeader.click();
    }

    public void verifyTableSorting(int columnIndex) {
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

    public void filterResultsByName(String filterText) {
        inputField.sendKeys(filterText);
    }

    public void waitForLoadingSpinnerToDisappear() {
        wait.until(ExpectedConditions.invisibilityOf(loadingSpinner));
    }

    public void verifyFilterResultsContain(String filterText) {
        List<WebElement> rows = table.findElements(By.cssSelector("tr"));
        for (WebElement row : rows) {
            String itemName = row.findElement(By.cssSelector("td:nth-of-type(1)")).getText().toLowerCase();
            assertTrue(itemName.contains(filterText), "Item name does not contain '" + filterText + "' after filtering");
        }
    }
}
