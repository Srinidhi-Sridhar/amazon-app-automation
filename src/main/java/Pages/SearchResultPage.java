package Pages;

import common.utilityfunctions.Page;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static common.AppiumManager.mobileDriver;


public class SearchResultPage extends Page {


    @AndroidFindBy(xpath = "//*[@resource-id='com.amazon.mShop.android.shopping:id/item_title']")
    public List<MobileElement> productNameButton;


    /**
     * Constructor to Initialize the Driver
     **/
    public SearchResultPage() {
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
    }


    /**
     * Method to Click on the Product
     */
    public boolean clickOnProdBasedOnIndex(int index) {
        List<MobileElement> mobileElementList = productNameButton;
        int size = mobileElementList.size();
        if (mobileElementList == null) {
            System.out.println("No Movies Present");
            return false;
        }
        if (size == 0) {
            System.out.println("No Elements Present");
            return false;
        }
        if (index > size) {
            System.out.println("Given index is not present");
            return false;
        }
        MobileElement element = mobileElementList.get(index);
        clickBy(element,"Product");
        return true;
    }
}

