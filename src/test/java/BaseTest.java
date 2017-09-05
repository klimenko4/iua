import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static WebDriver driver;
    protected static WebDriverWait wait;


    @BeforeMethod
    public static void beforeAll() {
        ChromeDriverManager.getInstance().setup();
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-fullscreen");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 15);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

}
