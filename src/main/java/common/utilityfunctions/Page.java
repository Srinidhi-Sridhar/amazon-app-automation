package common.utilityfunctions;

import common.AutomationConstants;
import common.reporting.ExtentReporting;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static common.AppiumManager.mobileDriver;


/**
 * The type Page.
 */
public class Page {

    private static Logger Log = Logger.getLogger(Page.class.getName());

    /**
     * Gets screen shot.
     *
     * @return the screen shot
     */
    public static String getScreenShot() {
        TakesScreenshot takesScreenshots = mobileDriver;
        String dest = takesScreenshots.getScreenshotAs(OutputType.BASE64);
        return "data:image/jpg;base64, " + dest;
    }


    /**
     * Gets screen shot as out put.
     */
    public static void getScreenShotAsOutPut() {
        TakesScreenshot takesScreenshots = mobileDriver;
        File source = takesScreenshots.getScreenshotAs(OutputType.FILE);
        String destination = AutomationConstants.SCREENSHOT_PATH;
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            Log.error("Could not Capture Screenshot", e);
        }
    }

    /**
     * Click by boolean.
     *
     * @param locator the locator
     * @return the boolean
     */
    protected boolean clickBy(WebElement locator, String buttonName) {
        try {
            new WebDriverWait(mobileDriver, AutomationConstants.WAIT_UNTIL_ELEMENT).until(ExpectedConditions.elementToBeClickable(locator)).click();
            ExtentReporting.logInfo("Clicked on " + buttonName);
            Log.info("Clicked on " + buttonName);
        } catch (WebDriverException e) {
            ExtentReporting.logFail("Could not Click " + buttonName, true);
            Log.error("Could not click " + buttonName, e);
            return false;
        }
        return true;
    }

    /**
     * Send keys by boolean.
     *
     * @param locator      the locator
     * @param keysToBeSent the keys to be sent
     * @return the boolean
     */
    protected boolean sendKeysBy(WebElement locator, String keysToBeSent, String buttonName) {
        try {
            new WebDriverWait(mobileDriver, AutomationConstants.WAIT_UNTIL_ELEMENT).until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(keysToBeSent);
            ExtentReporting.logInfo("Sent Keys to " + buttonName);
            Log.info("Sent Keys to " +buttonName);
        } catch (WebDriverException e) {
            ExtentReporting.logFail("Could not Send Keys " + buttonName, true);
            Log.error("Could not Send Keys " + buttonName, e);
            return false;
        }
        return true;
    }

    /**
     * Check if displayed boolean.
     *
     * @param locator the locator
     * @return the boolean
     */
    protected boolean checkIfDisplayed(WebElement locator, String buttonName) {
        try {
            new WebDriverWait(mobileDriver, AutomationConstants.WAIT_UNTIL_ELEMENT).until(ExpectedConditions.elementToBeClickable(locator)).isDisplayed();
            ExtentReporting.logInfo("Checking if is displayed " + buttonName);
            Log.info("Checking if is displayed" + buttonName);
        } catch (Exception e) {
            ExtentReporting.logError("Button is not displayed " + buttonName, true);
            return false;
        }
        return true;
    }

    /**
     * Navigate back.
     */
    protected void navigateBack() {
        mobileDriver.navigate().back();
    }

    /**
     * Vertical swipe.
     */
    public void verticalSwipe() {
        Dimension size = mobileDriver.manage().window().getSize();
        int anchor = (int) (size.width * 0.5);
        int startPoint = (int) (size.height * 0.7);
        int endPoint = (int) (size.height * 0.1);
        TouchAction action = new TouchAction(mobileDriver);
        action.press(new PointOption().withCoordinates(anchor, startPoint))
                .waitAction(new WaitOptions().withDuration(Duration.ofMillis(2000)))
                .moveTo(new PointOption().withCoordinates(endPoint, anchor))
                .release()
                .perform();
    }

    /**
     * Scroll to an element by text web element.
     *
     * @param mobileDriver the mobile driver
     * @param text         the text
     * @return the web element
     */
    protected WebElement scrollToAnElementByText(AppiumDriver mobileDriver, String text) {
        return mobileDriver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(new UiSelector().text(\"" + text + "\"));"));
    }

    /**
     * Press enter key in key board.
     */
    protected void pressEnterKeyInKeyBoard() {
        ((AndroidDriver<MobileElement>) mobileDriver).pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    /**
     * Safe sleep.
     *
     * @param milliseconds the milliseconds
     */
    protected static void safe_sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Log.error("Exception in safe sleep method", e);
        }
    }

    protected boolean waitForElement(WebElement element, String buttonName) {
        boolean isPresent = false;
        try {
            isPresent = new WebDriverWait(mobileDriver, AutomationConstants.WAIT_UNTIL_ELEMENT).until(ExpectedConditions.visibilityOfAllElements(element)).size() > 0;
            ExtentReporting.logInfo("Waited For Element is Present " + buttonName);
            Log.info("Waiting for element " + buttonName);
            return isPresent;
        } catch (WebDriverException e) {
            ExtentReporting.logInfo("Waited For Element is Not Present " + buttonName);
            return isPresent;
        }
    }

    protected void waitForInvisibilityOfElement(WebElement locator, String buttonName) {
        try {
            new WebDriverWait(mobileDriver, AutomationConstants.WAIT_UNTIL_ELEMENT).until(ExpectedConditions.invisibilityOf(locator));
            ExtentReporting.logInfo("Button Name" + buttonName);
            Log.info("Waited for Element " + buttonName);
        } catch (WebDriverException e) {
            ExtentReporting.logInfo("Waited for" + buttonName + "to be invisible but button is seen");
            Log.info("Waited for" + buttonName + "to be invisible but button is seen");
        }
    }
}



