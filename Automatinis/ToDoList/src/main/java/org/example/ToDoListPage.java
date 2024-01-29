import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ToDoListPage {
    private final WebDriver driver;

    public ToDoListPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getInputField() {
        return driver.findElement(By.cssSelector("#container > input[type=text]"));
    }

    public WebElement getAddedItem() {
        return driver.findElement(By.cssSelector("#container > ul > li"));
    }

    // Other methods for interacting with elements on the page
}
