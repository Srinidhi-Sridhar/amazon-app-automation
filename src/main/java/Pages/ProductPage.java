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
 * The type Product page.
 */
public class ProductPage extends Page {

    private static Logger Log = Logger.getLogger(ProductPage.class.getName());

    @AndroidFindBy(xpath = "//*[contains(@content-desc,'Cart') and @index='0']")
    public MobileElement openCart;

    @AndroidFindBy(xpath = "//*[starts-with(@text,rupees) and @class='android.widget.EditText']")
    public MobileElement priceButton;


    @AndroidFindBy(xpath = "//*[@resource-id='add-to-cart-button']")
    public MobileElement addToCartButton;


    @AndroidFindBy(xpath = "//*[@resource-id='title_feature_div']//following-sibling::android.view.View[1]")
    public MobileElement prodDescButton;


    /**
     * Constructor to Initialize the Driver
     */
    public ProductPage() {
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
    }

    /**
     * Prod price check string.
     *
     * @return the string
     */
    public String prodPriceCheck() {
        if (!(waitForElement(priceButton,"Price button"))) {
            verticalSwipe();
        }
        String productPrice=priceButton.getText().replaceAll("[a-zA-Z,\\s+]+", "");
        ExtentReporting.logInfo("Product Price in Product Page " +productPrice);
        Log.info("Product Price in Product Page " + productPrice);
        return productPrice;
    }

    /**
     * Prod desc check string.
     *
     * @return the string
     */
    public String prodDescCheck() {
        ExtentReporting.logInfo("Product Description in Product Page" + prodDescButton.getText());
        Log.info("Product Description in Product Page " + prodDescButton.getText());
        return prodDescButton.getText();
    }

    public void clickOnAddToCart() {
        if (!(waitForElement(addToCartButton,"add To CartButton")))
       {
           scrollToAnElementByText(mobileDriver,"Add to Cart");
       }
        clickBy(addToCartButton,"add To CartButton");
    }

    public void openCart()
    {
        clickBy(openCart,"Open Cart");
    }
}

