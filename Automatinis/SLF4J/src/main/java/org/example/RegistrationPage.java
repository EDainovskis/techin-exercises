import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    private static final Logger logger = LoggerFactory.getLogger(RegistrationPage.class);

    private final WebDriver driver;

    @FindBy(css = "input#email")
    private WebElement emailInput;

    @FindBy(css = "input#password")
    private WebElement passwordInput;

    @FindBy(css = "input#confirmPassword")
    private WebElement confirmPasswordInput;

    @FindBy(css = "input#name")
    private WebElement nameInput;

    @FindBy(css = ".btn.btn-lg.btn-primary.d-block.w-100")
    private WebElement registrationButton;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateTo() {
        driver.get("https://practice.expandtesting.com/notes/app/register");
        logger.info("Navigated to Registration Page");
    }

    public void enterRegistrationDetails(String email, String password, String confirmPassword, String name) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(confirmPassword);
        nameInput.sendKeys(name);
        logger.info("Entered registration details");
    }

    public void clickRegistrationButton() {
        registrationButton.click();
        logger.info("Clicked on the registration button");
    }
}
