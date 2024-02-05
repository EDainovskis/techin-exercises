//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.StandardCopyOption;
//
//public class ScreenshotListener implements ITestListener {
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        captureScreenshot(result);
//    }
//
//    private void captureScreenshot(ITestResult result) {
//        if (result.getMethod().getRealClass() != null) {
//            WebDriver driver = ((MyPageObject) result.getInstance()).getDriver();
//            if (driver instanceof TakesScreenshot) {
//                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//                Path destination = Path.of("screenshots", result.getName() + ".png");
//
//                try {
//                    Files.copy(screenshot.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);
//                    System.out.println("Screenshot saved: " + destination.toAbsolutePath());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//}
