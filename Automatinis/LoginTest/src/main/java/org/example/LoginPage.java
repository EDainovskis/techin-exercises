import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Define locators
    private final By usernameLocator = By.xpath("//div[@class='orangehrm-login-form']//p[1]");
    private final By passwordLocator = By.xpath("//div[@class='orangehrm-login-form']//p[2]");

    private final By inputNameLocator = By.xpath("//form//div[1]//input");
    private final By inputPasswordLocator = By.xpath("//input[@placeholder='Password']");
    private final By loginButtonLocator = By.xpath("//form//button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getUsernameText() {
        WebElement usernameElement = wait.until(ExpectedConditions.presenceOfElementLocated(usernameLocator));
        return usernameElement.getText().replace("Username :", "").trim();
    }

    public String getPasswordText() {
        WebElement passwordElement = wait.until(ExpectedConditions.presenceOfElementLocated(passwordLocator));
        return passwordElement.getText().replace("Password :", "").trim();
    }

    public void enterUsernameAndPassword(String username, String password) {
        WebElement inputName = wait.until(ExpectedConditions.presenceOfElementLocated(inputNameLocator));
        WebElement inputPassword = wait.until(ExpectedConditions.presenceOfElementLocated(inputPasswordLocator));

        inputName.sendKeys(username);
        inputPassword.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButton = wait.until(ExpectedConditions.presenceOfElementLocated(loginButtonLocator));
        loginButton.click();
    }
}
