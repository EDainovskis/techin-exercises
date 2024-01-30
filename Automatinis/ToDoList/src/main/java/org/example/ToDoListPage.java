import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;

public class ToDoListPage {
    private final WebDriver driver;
    private final Actions actions;

    public ToDoListPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void addTask(String taskName) {
        WebElement inputField = driver.findElement(By.cssSelector("#container > input[type=text]"));
        inputField.sendKeys(taskName);
        inputField.sendKeys(Keys.ENTER);
    }

    public void markTaskAsCompleted(int taskIndex) {
        WebElement task = driver.findElement(By.cssSelector("#container > ul > li:nth-child(" + taskIndex + ")"));
        actions.click(task).build().perform();
    }

    public void deleteTask(int taskIndex) {
        WebElement task = driver.findElement(By.cssSelector("#container > ul > li:nth-child(" + taskIndex + ")"));
        actions.moveToElement(task).perform();
        WebElement deleteButton = driver.findElement(By.cssSelector("#container > ul > li:nth-child(" + taskIndex + ") > span"));
        actions.click(deleteButton).build().perform();
    }

    public boolean isTaskPresent(String taskName) {
        WebElement task = driver.findElement(By.xpath("//li[contains(text(), '" + taskName + "')]"));
        return isElementPresent(task);
    }

    public boolean isTaskCompleted(int taskIndex) {
        WebElement task = driver.findElement(By.cssSelector("#container > ul > li:nth-child(" + taskIndex + ")"));
        return task.getAttribute("class").contains("completed");
    }

    private boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
