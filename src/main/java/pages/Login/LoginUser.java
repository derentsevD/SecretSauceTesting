package pages.Login;
import core.BasePage;
import org.openqa.selenium.By;

public class LoginUser extends BasePage {
    public static final By USERNAME_LOGIN_FIELD = By.id("user-name");
    public static final By PASSWORD_LOGIN_FIELD = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR_MESSAGE_CONTAINER = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]");

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
        type(USERNAME_LOGIN_FIELD,username);
        type(PASSWORD_LOGIN_FIELD,password);
        click(LOGIN_BUTTON);
    }

    /**
     * Tries logging in with a locked account, and checks if the correct error message is displayed
     * @return - return the text attribute of the error message container
     */
    public static String checkUserIsLockedOut(String attribute){
        return getTextFromElement(ERROR_MESSAGE_CONTAINER,attribute);
    }
}
