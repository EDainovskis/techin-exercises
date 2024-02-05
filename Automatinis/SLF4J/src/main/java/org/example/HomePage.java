import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);

    private final WebDriver driver;

    @FindBy(css = "[class='btn btn-outline-secondary btn-lg px-4']")
    private WebElement createAccountButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateTo() {
        driver.get("https://practice.expandtesting.com/notes/app");
        logger.info("Navigated to Home Page");
    }

    public void clickCreateAccountButton() {
        createAccountButton.click();
        logger.info("Clicked on the create account button");
    }
}
