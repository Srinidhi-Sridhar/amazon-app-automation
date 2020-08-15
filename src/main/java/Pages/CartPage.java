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


public class CartPage extends Page {
    private static Logger Log = Logger.getLogger(LogManager.class.getName());


    @AndroidFindBy(xpath = "//*[@class='android.widget.Image' and @index='0']")
    public MobileElement verifyDescButton;

    @AndroidFindBy(xpath = "//*[@class='android.widget.ListView' and @index='1']//following-sibling::*[@class='android.view.View' and @index='0']")
    public MobileElement verifyPriceButton;

    /**
     * Constructor to Initialize the Driver
     **/
    public CartPage() {
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
    }

    /**
     * Method to get description of the product
     **/

    public String getProductDescription() {
        ExtentReporting.logInfo("Product Desc in Cart Page " + verifyDescButton.getText());
        Log.info("Product Desc in Cart Page " + verifyDescButton.getText());
        return verifyDescButton.getText();
    }

    public String getProductPrice() {
        String priceButton = verifyPriceButton.getText().replaceAll(("[^a-zA-Z0-9.]"), "").split("\\.")[0];
        ExtentReporting.logInfo("Product Price in Cart Page" +priceButton);
        Log.info("Product Price in Cart Page " + priceButton);
        return  priceButton;
    }

}


