import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id ="login_field" )
    private WebElement loginField;
    @FindBy(id ="password" )
    private WebElement passwordField;
    @FindBy(name ="commit" )
    private WebElement signInButton;
    @FindBy(tagName ="h1" )
    private WebElement heading;
    @FindBy(className ="container" )
    private WebElement errorMessage;
    @FindBy(linkText ="Create an account" )
    private WebElement createAnAccount;

    public LoginPage typeLogin(String login){
        loginField.sendKeys(login);
        return this;
    }

    public LoginPage typePassword(String password){
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage signInWithInvalidCreds(String login, String  password){
        this.typeLogin(login);
        this.typePassword(password);
        signInButton.click();
        return PageFactory.initElements(driver, LoginPage.class);
    }

    public String getHeadingText(){
        return heading.getText();
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }

    public SignUpPage clickCreateAnAccount(){
        createAnAccount.click();
        return PageFactory.initElements(driver, SignUpPage.class);
    }
}
