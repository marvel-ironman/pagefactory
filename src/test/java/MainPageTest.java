import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/");

        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @Test
    public void signIn(){
        LoginPage loginPage = mainPage.clickSignIn();
        String heading = loginPage.getHeadingText();
        Assert.assertEquals(heading, "Sign in to GitHub");
    }

    @Test
    public void registerFailTest(){
        SignUpPage signUpPage = mainPage.registration("userLog", "userEma", "12qw1562e");
        String error = signUpPage.getErrorMessage();
        Assert.assertEquals(error,"There were problems creating your account.");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
