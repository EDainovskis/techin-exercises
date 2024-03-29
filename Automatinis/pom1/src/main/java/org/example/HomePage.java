import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToLoginPage() {

        WebElement loginLink = driver.findElement(By.cssSelector("#wishlist-total > span"));
        loginLink.click();
    }
}
