import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String password) {
        WebElement emailInput = driver.findElement(By.cssSelector("#input-email"));
        emailInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(By.cssSelector("#input-password"));
        passwordInput.sendKeys(password);

        WebElement loginButton = driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
        loginButton.click();
    }
}
