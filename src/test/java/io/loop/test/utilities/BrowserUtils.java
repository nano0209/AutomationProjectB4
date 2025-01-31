package io.loop.test.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Set;

import static org.testng.Assert.assertTrue;

public class BrowserUtils {
    /**
     * validate if driver switched to expected url or title
     *
     * @param driver
     * @param expectedUrl
     * @param expectedTitle
     * @author Naima
     * implements assertion
     * note; usually we do not do validation in metjhod this is for practicing purposes
     */

    public static void switchWindowAndValidate(WebDriver driver, String expectedUrl, String expectedTitle) {
        expectedTitle = expectedTitle.toLowerCase();
        expectedUrl = expectedUrl.toLowerCase();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles) {
            driver.switchTo().window(each);
            if (driver.getCurrentUrl().toLowerCase().contains(expectedUrl)) {
                break;
            }
        }

        //after stopping on expected url, validate the title
        assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));


    }

    /*

     */

    public static void switchToWindow(WebDriver driver, String targetTitle){
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().contains(targetTitle)) {
                return;

            }
            driver.switchTo().window(origin);
        }


    }
}