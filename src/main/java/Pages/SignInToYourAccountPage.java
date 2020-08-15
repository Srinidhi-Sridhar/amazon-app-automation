package Pages;


import common.utilityfunctions.Page;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static common.AppiumManager.mobileDriver;


/**
 * The type Sign in to your account page.
 */
public class SignInToYourAccountPage extends Page {
    /**
     * Constructor to Initialize the Driver
     */
    public SignInToYourAccountPage() {
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
    }


    @AndroidFindBy(id = "sign_in_button")
    public MobileElement signInAsExistingUser;

    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/new_user")
    public MobileElement signInAsNewUser;

    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/skip_sign_in_button")
    public MobileElement skipSignIn;

    @AndroidBy(id = "com.amazon.mShop.android.shopping:id/apspinner_progressbar")
    public MobileElement appSpinner;

    public void clickOnAsExistingUser() {
        clickBy(signInAsExistingUser, "Existing User");
    }

    /**
     * Click on as new user.
     */
    public void clickOnAsNewUser() {
        clickBy(signInAsNewUser, "New User");
    }

    /**
     * Skip sign in.
     */
    public void skipSignIn() {
        clickBy(skipSignIn, "Skip Sign In");
    }

    /**
     * Wait for spinner to disappear.
     *//*
    public void waitForSpinnerToDisappear() {
        waitForInvisibilityOfElement(appSpinner, "App spinner");
    }*/

}

