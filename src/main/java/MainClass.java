import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainClass {

    static WebDriver driver;

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //driver.get("https://github.com/join?source=header-home");
        driver.get("https://github.com/");

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
       // MainPage mainPage = new MainPage(driver);
        //mainPage.registration("userLog", "userEma", "12qw1562e");
        SignUpPage signUpPage = mainPage.registration("userLog", "userEma", "12qw1562e");

        String error = signUpPage.getErrorMessage();
        System.out.println(error);
//        SignUpPage signUpPage = PageFactory.initElements(driver,SignUpPage.class);
//        boolean butt = signUpPage.createAnAccountButtonEnable();
//        System.out.println(butt);



    }
}
