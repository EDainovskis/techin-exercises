import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    private final WebDriver driver;

    @FindBy(css = "input#email")
    private WebElement emailInput;

    @FindBy(css = "input#password")
    private WebElement passwordInput;

    @FindBy(css = "[class='btn btn-lg btn-primary d-block w-100']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateTo() {
        driver.get("https://practice.expandtesting.com/notes/app/login");
        logger.info("Navigated to Login Page");
    }

    public void enterLoginDetails(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        logger.info("Entered login details");
    }

    public void clickLoginButton() {
        loginButton.click();
        logger.info("Clicked on the login button");
    }
}
