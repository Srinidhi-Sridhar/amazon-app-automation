package Pages;


import common.AutomationConstants;
import common.utilityfunctions.LogManager;
import common.utilityfunctions.Page;
import common.utilityfunctions.ReadProperties;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;


import static common.AppiumManager.mobileDriver;


/**
 * The type Login page.
 */
public class LoginPage extends Page {

    private static Logger Log = Logger.getLogger(LoginPage.class.getName());
    ReadProperties readProperties = new ReadProperties();

    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText' and @resource-id='ap_email_login']")
    public MobileElement userNameButton;

    @AndroidFindBy(xpath = "//*[@class='android.widget.Button' and @resource-id='continue']")
    public MobileElement continueButton;

    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText' and @resource-id='ap_password']")
    public MobileElement passwordButton;

    @AndroidFindBy(xpath = "//*[@class='android.widget.Button' and @resource-id='signInSubmit']")
    public MobileElement loginButton;

    @AndroidBy(id="com.amazon.mShop.android.shopping:id/apspinner_progressbar")
    public MobileElement appSpinner;

    public String userName = readProperties.getProperties(AutomationConstants.GLOBAL_PROPERTIES_PATH).getProperty(AutomationConstants.USER_NAME);
    public String passWord = readProperties.getProperties(AutomationConstants.GLOBAL_PROPERTIES_PATH).getProperty(AutomationConstants.PASS_WORD);


    /**
     * Constructor to Initialize the Driver
     **/

    public LoginPage() {
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
    }

    /**
     * Method to Login
     *
     * @return HomePage
     */
    public void loginIn() {
        sendKeysBy(userNameButton, userName,"User Name");
        clickBy(continueButton,"Continue Button");
        sendKeysBy(passwordButton, passWord,"password button");
        clickBy(loginButton,"login button");
    }
}
