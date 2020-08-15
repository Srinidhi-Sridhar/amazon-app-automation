package Pages;

import common.reporting.ExtentReporting;
import common.utilityfunctions.LogManager;
import common.utilityfunctions.Page;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import static common.AppiumManager.mobileDriver;


/**
 * The type Search page.
 */
public class SearchPage extends Page {

    private static Logger Log = Logger.getLogger(SearchPage.class.getName());

    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/rs_search_src_text")
    public MobileElement searchButton;

    String productName = "TV 65 Inches";

    /**
     * Constructor to Initialize the Driver
     */
    public SearchPage() {
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);

    }
    public void verifyLogin() {
        waitForElement(searchButton,"Waiting for Search Button");
        ExtentReporting.logInfo("Login Successful");
        Log.info("Login Successful ");
    }



    /**
     * Search product.
     */
    public void searchProduct() {
        clickBy(searchButton,"Search button");
        sendKeysBy(searchButton, productName,"Search button");
        pressEnterKeyInKeyBoard();
        safe_sleep(3000);
    }

    public void swipeOnce() {
        verticalSwipe();
    }
}

