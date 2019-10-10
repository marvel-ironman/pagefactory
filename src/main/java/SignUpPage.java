import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage {

   private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(tagName ="h1")
    private WebElement createAccountText;
    @FindBy(id = "user_login")
    private WebElement userName;
    @FindBy(id = "user_email")
    private WebElement userEmail;
    @FindBy(id = "user_password")
    private WebElement userPassword;
    @FindBy(id = "signup_button")
    private WebElement createAnAccountButton;
    @FindBy(xpath = "//div[@class='flash flash-error my-3']")
    private WebElement errorMessage;

    public String getCreateAccText(){
      return   createAccountText.getText();
    }

    public SignUpPage typeUserName(String username){
       userName.sendKeys(username);
        return this;
    }

    public SignUpPage typeUserEmail(String email){
        userEmail.sendKeys(email);
        return this;
    }

    public SignUpPage typeUserPassword(String password){
        userPassword.sendKeys(password);
        return this;
    }

    public boolean createAnAccountButtonEnable(){
        return createAnAccountButton.isEnabled();
    }

    public SignUpPage signUpWithInvalidCreds(String username, String email, String password){
        this.typeUserName(username);
        this.typeUserEmail(email);
        this.typeUserPassword(password);
        this.createAnAccountButtonEnable();
        return this;
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }

}
