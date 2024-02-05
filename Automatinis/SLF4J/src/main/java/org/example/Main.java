//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
////import org.testng.annotations.Listeners;
////
////@Listeners(ScreenshotListener.class)
//
//public class Main {
//
//    private static WebDriver driver;
//
//    @BeforeAll
//    static void setUp() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//    }
//
//    @Test
//    void testWebElement() {
//        driver.get("https://practice.expandtesting.com/notes/app");
//
//
//        MyPageObject myPage = new MyPageObject(driver);
//
//
//        myPage.clickCreateAccountButton();
//    }
//
//    @Test
//    void testRegistration() {
//        driver.get("https://practice.expandtesting.com/notes/app/register");
//
//
//        MyPageObject myPage = new MyPageObject(driver);
//
//
//        myPage.enterEmail("eee@test.com");
//        myPage.enterPassword("test123");
//        myPage.confirmPassword("test123");
//        myPage.enterName("tester");
//
//
//        myPage.clickRegistrationButton();
//    }
//
//    @Test
//    void testLogin() {
//        driver.get("https://practice.expandtesting.com/notes/app/login");
//
//
//        MyPageObject myPage = new MyPageObject(driver);
//
//
//        myPage.enterEmail("eee@test.com");
//        myPage.enterPassword("test123");
//
//
//        myPage.clickLoginButton();
//    }
//}
//
//class MyPageObject {
//    private static final Logger logger = LoggerFactory.getLogger(MyPageObject.class);
//    @FindBy(css = "[class='btn btn-outline-secondary btn-lg px-4']")
//    private WebElement createAccountButton;
//
//    @FindBy(css = "input#email")
//    private WebElement emailInput;
//
//    @FindBy(css = "input#password")
//    private WebElement passwordInput;
//
//    @FindBy(css = "input#confirmPassword")
//    private WebElement confirmPasswordInput;
//
//    @FindBy(css = "input#name")
//    private WebElement nameInput;
//
//    @FindBy(css = ".btn.btn-lg.btn-primary.d-block.w-100")
//    private WebElement registrationButton;
//
//    @FindBy(css = "[class='btn btn-lg btn-primary d-block w-100']")
//    private WebElement loginButton;
//
//
//    public MyPageObject(WebDriver driver) {
//        PageFactory.initElements(driver, this);
//    }
//
//
//    public void clickCreateAccountButton() {
//        createAccountButton.click();
//        logger.info("Clicked on the create account button");
//    }
//
//
//    public void enterEmail(String email) {
//        emailInput.sendKeys(email);
//        logger.info("Entered email: {}", email);
//    }
//
//    public void enterPassword(String password) {
//        passwordInput.sendKeys(password);
//        logger.info("Entered password");
//    }
//
//    public void confirmPassword(String confirmPassword) {
//        confirmPasswordInput.sendKeys(confirmPassword);
//        logger.info("Confirmed password");
//    }
//
//
//    public void enterName(String name) {
//        nameInput.sendKeys(name);
//        logger.info("Entered name: {}", name);
//    }
//
//
//    public void clickRegistrationButton() {
//        registrationButton.click();
//        logger.info("Clicked on the registration button");
//    }
//
//
//    public void clickLoginButton() {
//        loginButton.click();
//        logger.info("Clicked on the login button");
//    }
//}
