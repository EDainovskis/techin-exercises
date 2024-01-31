import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

    private static WebDriver driver;

    @BeforeAll
    static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void testLogin() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

     
        WebDriverWait wait = new WebDriverWait(driver, 10);



        WebElement usernameElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/div/div/p[1]")));
        WebElement passwordElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/div/div/p[2]")));


        String usernameText = usernameElement.getText().replace("Username :", "").trim();
        String passwordText = passwordElement.getText().replace("Password :", "").trim();


        System.out.println("Username: " + usernameText);
        System.out.println("Password: " + passwordText);


        WebElement inputName = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
        WebElement inputPassword = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));


        inputName.sendKeys(usernameText);
        inputPassword.sendKeys(passwordText);


        Actions actions = new Actions(driver);
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
        actions.click(loginButton).build().perform();


    }
}
