package pages.Login;
import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyBrowser;

public class LoginUser extends BasePage {
    @FindBy(id = "user-name")
    static WebElement usernameLoginField;

    @FindBy(id = "password")
    static WebElement passwordLoginField;

    @FindBy(id = "login-button")
    static WebElement loginButton;

    @FindBy(className = "error-message-container")
    static WebElement errorMessageContainer;

    static {
        PageFactory.initElements(MyBrowser.driver, LoginUser.class);
    }

    /**
     * Opens the landing page of the testing website
     */
    public static void goTo(){openUrl("https://www.saucedemo.com/");}

    /**
     * Logs in as a user with the provided credentials
     * @param username the username you would like to be logged in with
     * @param password the password for the relevant username
     */
    public static void userLogin(String username, String password){
        type(usernameLoginField,username);
        type(passwordLoginField,password);
        click(loginButton);
    }

    public static String checkUserIsLockedOut(){
        return errorMessageContainer.getAttribute("textContent");
    }
}
