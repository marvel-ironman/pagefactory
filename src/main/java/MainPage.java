import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(linkText ="Sign in")
    private WebElement signInButton;
    @FindBy(linkText ="Sign up")
    private WebElement signUpButton;
    @FindBy(id = "user[login]")
    private WebElement userLogin;
    @FindBy(id = "user[email]")
    private WebElement userEmail;
    @FindBy(id = "user[password]")
    private WebElement userPassword;
    @FindBy(xpath = "//form/button[text()='Sign up for GitHub']")
    private WebElement signUpForGitHubButton;

    public LoginPage clickSignIn(){
        signInButton.click();
        return PageFactory.initElements(driver, LoginPage.class);
    }

    public SignUpPage clickSignUp(){
        signUpButton.click();
        return new SignUpPage(driver);
    }

    public SignUpPage clickSignUpForGithub(){
        signUpForGitHubButton.click();
        return PageFactory.initElements(driver, SignUpPage.class);
    }

    public MainPage typeUserLogin(String login){
       userLogin.sendKeys(login);
        return this;
    }

    public MainPage typeUserEmail(String email){
        userEmail.sendKeys(email);
        return this;
    }

    public MainPage typeUserPassword(String password){
        userPassword.sendKeys(password);
        return this;
    }

    public SignUpPage registration(String login, String email, String password){
        this.typeUserLogin(login);
        this.typeUserEmail(email);
        this.typeUserPassword(password);
        this.clickSignUpForGithub();
        return PageFactory.initElements(driver,SignUpPage.class);
    }

}
